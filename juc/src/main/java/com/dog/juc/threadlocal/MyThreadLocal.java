package com.dog.juc.threadlocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author dog
 * @description 销售卖房子案例
 */
public class MyThreadLocal {
    public static void main(String[] args) {
        House house = new House();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int size = new Random().nextInt(5) + 1;
                try {
                    for (int j = 0; j < size; j++) {
                        house.saleHouse();
                        house.saleVolumeByTL();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t"+"号人员买了" + house.saleVolume.get());
                } finally {
                    house.saleVolume.remove();
                }
            }, String.valueOf(i)+"thread").start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"买了多少套"+house.saleCount);
        System.out.println(Thread.currentThread().getName()+"\tmaile"+house.saleVolume.get());
    }


}

class House//资源类
{
    int saleCount = 0;

    public synchronized void saleHouse() {
        saleCount = saleCount + 1;
    }
    ThreadLocal<Integer> saleVolume = ThreadLocal.withInitial(()->0);

    void saleVolumeByTL(){
        saleVolume.set(saleVolume.get()+1);
    }

}
