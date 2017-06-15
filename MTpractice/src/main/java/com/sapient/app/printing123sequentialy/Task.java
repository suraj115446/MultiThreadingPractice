package com.sapient.app.printing123sequentialy;

public class Task implements Runnable {

    private final Object object;
    private volatile int numberPrinted = 1;
    private volatile int threadNumber = 1;

    Task(Object object) {
        this.object = object;
    }

    public void run() {
        for (int i = Integer.parseInt(Thread.currentThread().getName()); ; ) {
            //threadNumber = i%3;
            synchronized (object) {
                if (threadNumber != i % 3) {

                    while (threadNumber != i % 3) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "is printing  : " + i);
                    i += 3;
                    object.notifyAll();
                    threadNumber++;
                    threadNumber = threadNumber % 3;

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }
}
