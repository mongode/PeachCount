package com.ixw;

public class Main {

    public static void main(String[] args) {
        PeachNum peachNum = new PeachNum();
    
        AddPeach addThread = new AddPeach("addPeach01", peachNum, 6, 5000L);
        EatPeach eatThread01 = new EatPeach("eatPeach01", peachNum, 2, 2000L);
        EatPeach eatThread02 = new EatPeach("eatPeach02", peachNum, 5, 6000L);
        
        addThread.start();
        eatThread01.start();
        eatThread02.start();
    }
}
