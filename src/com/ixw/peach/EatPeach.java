package com.ixw.peach;

public class EatPeach implements Runnable {
    
    private Thread thread;
    private String threadName;
    private Integer eatNum;
    private Long sleepTime;
    private Integer currentNum;
    
    public EatPeach(String threadName, Integer eatNum, Long sleepTime) {
        this.threadName = threadName;
        this.eatNum = eatNum;
        this.sleepTime = sleepTime;
        System.out.println("Creating " + threadName);
    }
    
    @Override
    public String toString() {
        return "EatPeach{" +
                "thread=" + thread +
                ", threadName='" + threadName + '\'' +
                ", peachNum_operCount=" + PeachNum.getOperCount() +
                ", eatNum=" + eatNum +
                ", sleepTime=" + sleepTime +
                ", currentNum=" + currentNum +
                '}';
    }
    
    @Override
    public synchronized void run() {
        System.out.println("Running " + threadName);
        while (PeachNum.getRunTag()) {
            currentNum = PeachNum.getPn() - eatNum;
            if (currentNum <= 0) {
                PeachNum.setRunTag();
                this.eatNum = PeachNum.getPn();
                this.currentNum = 0;
                PeachNum.setPn(0);
            }
            PeachNum.setPn(currentNum);
            PeachNum.setOperCount(PeachNum.getOperCount()+1);
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
