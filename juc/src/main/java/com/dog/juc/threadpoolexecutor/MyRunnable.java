package com.dog.juc.threadpoolexecutor;

import java.util.Date;

/**
 * @author dog
 * @description
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String s){
        this.command = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"start:"+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+"end:"+new Date());
    }

    @Override
    public String toString(){
        return this.command;
    }

    private void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
