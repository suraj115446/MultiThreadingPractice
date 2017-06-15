package com.sapient.app.DelayedBlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Suraj on 3/12/2017.
 */
public class ProducerWithBlockingQueue implements Runnable {

    private final BlockingQueue<String> blockingQueue;
    int i;

    public ProducerWithBlockingQueue(BlockingQueue<String> blockingQueue) {

        this.blockingQueue = blockingQueue;
        this.i = 0;
    }

    public void run() {
        while (true) {

            if (blockingQueue.remainingCapacity() == 0) {
                System.out.println("Queue is full");
            } else {


                try {
                    blockingQueue.put("" + i);
                    System.out.println("produced " + i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
