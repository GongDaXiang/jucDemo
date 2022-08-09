package com.dog.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dog
 * @description
 */
public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        MyData my = new MyData();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            pool.submit(()->{
                Integer before;
                Integer after;
                try {
                    before = my.data.get();
                    my.add();
                    after = my.data.get();
                } finally {
//                    my.data.remove();
                }
                System.out.println(Thread.currentThread().getName()+"\tbefore:"+before+"\tafter:"+after);
            });
            new Thread(my::add);
        }
    }
}

class MyData
{
    ThreadLocal<Integer> data = ThreadLocal.withInitial(()->0);
    void add(){
        data.set(data.get()+1);
    }
}
