package com.ixw;

import com.ixw.peach.AddPeach;
import com.ixw.peach.EatPeach;
import com.ixw.peach.PeachConfig;

public class Main {

    public static void main(String[] args) {
        AddPeach addThread = new AddPeach(PeachConfig.ADD01.getThreadName(),
                PeachConfig.ADD01.getAddNum(), PeachConfig.ADD01.getSleepTime());
        EatPeach eatThread01 = new EatPeach(PeachConfig.EAT01.getThreadName(),
                PeachConfig.EAT01.getAddNum(), PeachConfig.EAT01.getSleepTime());
        EatPeach eatThread02 = new EatPeach(PeachConfig.EAT02.getThreadName(),
                PeachConfig.EAT02.getAddNum(), PeachConfig.EAT02.getSleepTime());
        
        addThread.start();
        eatThread01.start();
        eatThread02.start();
    }
}
