package com.sapient.app.printing123sequentialy;

public class Application {

    public static void main(String[] args) {

        //  **************************  Thread Scheduling Example   **********************************
        Task task = new Task(new Object());
        Thread thread1= new Thread(task,"1");
        Thread thread2= new Thread(task,"2");
        Thread thread3= new Thread(task,"3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
