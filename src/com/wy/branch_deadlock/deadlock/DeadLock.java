package com.wy.branch_deadlock.deadlock;

import com.wy.branch_deadlock.thread.ThreadTest;

public class DeadLock {
    private static ThreadTest tt1=new ThreadTest();
    private static ThreadTest tt2=new ThreadTest();

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            public void run() {
                synchronized (tt1) {
                    System.out.println("123");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (tt2) {
                        System.out.println("1234");
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            public void run() {
                synchronized (tt2) {
                    System.out.println("234");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (tt1) {
                        System.out.println("2345");
                    }
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
