package com.sapient.app.DelayedBlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Suraj on 3/12/2017.
 */
public class ConsumerWithBlockingQueue implements Runnable {


    private final BlockingQueue<String> blockingQueue;

    public ConsumerWithBlockingQueue(BlockingQueue<String> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

    public void run() {

        while (true) {

            if (blockingQueue.isEmpty()) {
                System.out.println("List is empty");
            } else {

                try {
                    System.out.println("consumed " + blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
