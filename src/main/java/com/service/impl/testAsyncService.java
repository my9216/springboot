package com.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class testAsyncService {

    @Async
    public void runAsync1(){
        try {
            System.out.println("in the runAsync1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("testPool2")
    public void runAsync2(){
        try {
            System.out.println("in the runAsync2");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
