package com.ixw;

public class RunnaleDemo implements Runnable {
    
    private Thread thread;
    private String threadName;
    
    public RunnaleDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }
    
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }
    
    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
