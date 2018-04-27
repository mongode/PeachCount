package com.ixw;

public class PeachNum {
    
    public static Integer operCount = 0;
    
    public static Integer pn = 10;
    
    public static boolean runTag = true;
    
    public PeachNum() {
    }
    
    public static Integer getOperCount() {
        return operCount;
    }
    
    public static void setOperCount(Integer operCount) {
        PeachNum.operCount = operCount;
    }
    
    public static Integer getPn() {
        return pn;
    }
    
    public static void setPn(Integer pn) {
        PeachNum.pn = pn;
    }
    
    public static boolean getRunTag() {
        return runTag;
    }
    
    public static void setRunTag(boolean runTag) {
        PeachNum.runTag = runTag;
    }
}
