package com.ixw.peach;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PeachNum {
    
    public static Integer operCount = 0;
    
    public static Integer pn = PeachConfig.PN.getPeachNum();
    
    public static boolean runTag = true;
    
    public PeachNum() {
    }
    
    static Integer getOperCount() {
        return operCount;
    }
    
    static void setOperCount(Integer operCount) {
        PeachNum.operCount = operCount;
    }
    
    static Integer getPn() {
        return pn;
    }
    
    static void setPn(Integer pn) {
        PeachNum.pn = pn;
    }
    
    static boolean getRunTag() {
        return runTag;
    }
    
    static void setRunTag() {
        PeachNum.runTag = false;
    }
}
