package com.juc;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest {

    public static void main(String[] args) {

        SynchronousQueue<String> synQueue = new SynchronousQueue<String>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "\t put AA" );
                synQueue.put("A");
                System.out.println(Thread.currentThread().getName() + "\t put BB" );
                synQueue.put("B");
                System.out.println(Thread.currentThread().getName() + "\t put CC" );
                synQueue.put("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                synQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take AA" );

                TimeUnit.SECONDS.sleep(2);
                synQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take BB" );

                TimeUnit.SECONDS.sleep(2);
                synQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take CC" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"BBB").start();




    }


}
