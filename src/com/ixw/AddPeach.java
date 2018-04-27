package com.ixw;

public class AddPeach implements Runnable {
    
    private Thread thread;
    private String threadName;
    private PeachNum peachNum;
    private Integer addNum;
    private Long sleepTime;
    private Integer currentNum;
    
    public AddPeach(String threadName, PeachNum peachNum, Integer addNum, Long sleepTime) {
        this.threadName = threadName;
        this.peachNum = peachNum;
        this.addNum = addNum;
        this.sleepTime = sleepTime;
        System.out.println("Creating " + threadName);
    }
    
    @Override
    public String toString() {
        return "AddPeach{" +
                "thread=" + thread +
                ", threadName='" + threadName + '\'' +
                ", peachNum_operCount=" + peachNum.getOperCount() +
                ", addNum=" + addNum +
                ", sleepTime=" + sleepTime +
                ", currentNum=" + currentNum +
                '}';
    }
    
    @Override
    public synchronized void run() {
        System.out.println("Running " + threadName);
        while (peachNum.getRunTag()) {
            currentNum = peachNum.getPn() + addNum;
            peachNum.setPn(currentNum);
            peachNum.setOperCount(peachNum.getOperCount()+1);
            System.out.println(this.toString());
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }
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
