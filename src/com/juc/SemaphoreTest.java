package com.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量 ，场景：抢车位
 * m辆车争抢n个车位，信号量值可变化可伸缩，多个线程共享多个资源
 * 10辆车4个车位  车位满其他排队，走一辆可进一辆
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();    //抢占停车位
                    System.out.println(Thread.currentThread().getName()+" 抢到车位，停车");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+" 释放车位");
                    semaphore.release();    //释放停车位
                }
            },String.valueOf(i)).start();
        }
    }
}
