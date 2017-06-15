package com.sapient.app;

import java.util.Queue;

/**
 * Created by Suraj on 1/23/2017.
 */
public class Producer implements Runnable {

    private Queue<String> list;
    private int MAX_SIZE = 10;
    private int i;

    public Producer(Queue<String> list) {
        this.list = list;
        i = 0;
    }

    public void run() {


        while (true) {
            synchronized (list) {

                if (list.size() >= MAX_SIZE) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {

                    list.add("" + i);
                    list.notify();
                    System.out.println("Produced "+ i++);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }
}
