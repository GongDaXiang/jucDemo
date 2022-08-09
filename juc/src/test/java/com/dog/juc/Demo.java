package com.dog.juc;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author dog
 * @description
 */
public class Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DateFormat.FORMAT_THREAD_LOCAL.set(new SimpleDateFormat("yyyy"+ new Random().nextInt(10)));
                System.out.println(DateFormat.FORMAT_THREAD_LOCAL.get().toPattern());
            },"11111").start();
        }
        System.out.println(DateFormat.FORMAT_THREAD_LOCAL.get().toPattern());
    }
}

class DateFormat {
    public static final ThreadLocal<SimpleDateFormat> FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
}
