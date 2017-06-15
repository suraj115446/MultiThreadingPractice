package com.sapient.app;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<String> list;
    private int MAX_SIZE = 10;

    public Consumer(Queue<String> list) {
        this.list = list;
    }


    public void run() {

        while (true) {
            synchronized (list) {

                if (list.size() == 0) {
                    System.out.println("List is empty");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Consumed " + list.remove());
                    list.notify();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
