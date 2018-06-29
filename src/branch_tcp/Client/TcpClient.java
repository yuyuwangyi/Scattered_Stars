package branch_tcp.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) {
        try {

            System.out.println("创建客户端，并连接服务端...");
            InetAddress address = InetAddress.getByName("192.168.11.234");
            Socket socket = new Socket(address, 12345);
            ReceiverMsg rm = new ReceiverMsg(socket);
            SendMsg sm = new SendMsg(socket);

            Thread t1 = new Thread(rm);
            Thread t2 = new Thread(sm);

            t1.start();
            t2.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class ReceiverMsg implements Runnable {

        private Socket socket;
        private String name;

        public ReceiverMsg(Socket socket) {
            this.socket = socket;
            name = socket.getInetAddress().getHostName();
        }

        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                while (true) {
                    String readLine = br.readLine();
                    if (readLine == null) {
                        break;
                    }
                    System.out.println(name+":" + readLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static class SendMsg implements Runnable {

        private Socket socket;
        private PrintWriter pw;

        public SendMsg(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                @SuppressWarnings("resource")
                Scanner scanner =new Scanner(System.in);

                pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
                System.out.println("请输入昵称");
                pw.println(scanner.next());
                while (true) {
                    pw.println(scanner.next());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
