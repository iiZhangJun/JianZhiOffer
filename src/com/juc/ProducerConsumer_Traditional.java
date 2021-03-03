package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */

public class ProducerConsumer_Traditional {

    public static void main(String[] args) {
        sharedData sharedData = new sharedData();
        new Thread(()->{
            for (int i=1;i<=5;i++){
                try {
                    sharedData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者").start();

        new Thread(()->{
            for (int i=1;i<=5;i++){
                try {
                    sharedData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();
    }
}

/**
 * 高并发环境，高内聚低耦合条件下，
 * 线程  操作（资源类方法）  资源类，      即线程调用资源类方法操作
 * 判断  干活   通知
 * 防止虚假唤醒机制，使用while判断，而非if判断
 */
class sharedData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //1.判断
            while (number != 0){
                //2.生产线程等待不能生产
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t "+ number);
            // 通知唤醒
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            //1.判断
            while (number == 0){
                //2.生产线程等待不能生产
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t "+ number);
            // 通知唤醒
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
