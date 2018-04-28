package com.ixw.peach;

public enum PeachConfig {
    ADD01("addPeach00", 6, 5000L),
    EAT01("eatPeach01", 2, 2000L),
    EAT02("eatPeach02", 5, 6000L),
    PN(10)
    ;
    
    private String threadName;
    private Integer peachNum;
    private Integer addNum;
    private Long sleepTime;
    
    PeachConfig(String threadName, Integer addNum, Long sleepTime) {
        this.threadName = threadName;
        this.addNum = addNum;
        this.sleepTime = sleepTime;
    }
    
    PeachConfig(Integer peachNum) {
        this.peachNum = peachNum;
    }
    
    public String getThreadName() {
        return threadName;
    }
    
    public Integer getPeachNum() {
        return peachNum;
    }
    
    public Integer getAddNum() {
        return addNum;
    }
    
    public Long getSleepTime() {
        return sleepTime;
    }
}
