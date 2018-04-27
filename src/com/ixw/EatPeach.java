package com.ixw;

public class EatPeach implements Runnable {
    
    private Thread thread;
    private String threadName;
    private PeachNum peachNum;
    private Integer eatNum;
    private Long sleepTime;
    private Integer currentNum;
    
    public EatPeach(String threadName, PeachNum peachNum, Integer eatNum, Long sleepTime) {
        this.threadName = threadName;
        this.peachNum = peachNum;
        this.eatNum = eatNum;
        this.sleepTime = sleepTime;
        System.out.println("Creating " + threadName);
    }
    
    @Override
    public synchronized String toString() {
        return "EatPeach{" +
                "thread=" + thread +
                ", threadName='" + threadName + '\'' +
                ", peachNum_operCount=" + peachNum.getOperCount() +
                ", eatNum=" + eatNum +
                ", sleepTime=" + sleepTime +
                ", currentNum=" + currentNum +
                '}';
    }
    
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        while (peachNum.getRunTag()) {
            currentNum = peachNum.getPn() - eatNum;
            if (currentNum <= 0) {
                peachNum.setRunTag(false);
                this.eatNum = peachNum.getPn();
                peachNum.setPn(0);
                break;
            }
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
