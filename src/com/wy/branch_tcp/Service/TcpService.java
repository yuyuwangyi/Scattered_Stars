package com.wy.branch_tcp.Service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TcpService {
    static HashMap<String, Socket> map=new HashMap<>();
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(30);
        LinkedList<Socket> list = new LinkedList<>();
        try {
            System.out.println("创建服务器");
            @SuppressWarnings("resource")
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("等待客户端连接");
            while (true) {
                Socket accept = serverSocket.accept();
                System.out.println("客户端已连接");
                list.add(accept);
                executor.execute(new Recever(list, accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class Recever implements Runnable {
        private Socket socket;
        private LinkedList<Socket> list;

        public Recever(LinkedList<Socket> list, Socket socket) {
            this.list = list;
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(input);
                BufferedReader br = new BufferedReader(isr);
                String name = br.readLine();
                map.put(name, socket);
                while (true) {
                    String readLine = br.readLine();
                    int indexOf = readLine.indexOf("@");
                    if (indexOf != -1) {
                        String substring = readLine.substring(indexOf+1, readLine.length());
                        Set<Map.Entry<String, Socket>> entrySet = map.entrySet();
                        for (Map.Entry<String, Socket> entry : entrySet) {
                            if (entry.getKey().equals(substring)) {
                                PrintWriter pw = new PrintWriter(
                                        new OutputStreamWriter(entry.getValue().getOutputStream()), true);
                                pw.println(name + "说:" + readLine.substring(0,indexOf));
                            }
                        }
                    } else {
                        for (Socket socket1 : list) {
                            if (socket1 != socket) {
                                PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket1.getOutputStream()),
                                        true);
                                pw.println(name + "说:" + readLine);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
