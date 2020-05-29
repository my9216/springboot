package com;

import java.util.ArrayList;
import java.util.List;

public class test2 {

    public static void main(String[] args) throws InterruptedException {
        List<Gift> giftList = new ArrayList<>();
        for(int i=0;i<1000000;i++){
            Gift gift = new Gift(i,"gitfId"+i,"gitfId"+i,i);
            giftList.add(gift);
        }
        Thread.sleep(1000000);
    }
}
