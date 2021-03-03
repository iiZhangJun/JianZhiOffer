package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的Condition用来实现分组唤醒需要唤醒的线程，可以精确唤醒
 */
public class LockConditionTest {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sharedResource.print5();
            }
        },"AAA").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sharedResource.print10();
            }
        },"BBB").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sharedResource.print15();
            }
        },"CCC").start();
    }
}

class SharedResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition con1 = lock.newCondition();
    private Condition con2 = lock.newCondition();
    private Condition con3 = lock.newCondition();

    public void print5(){
        lock.lock();
        // 判断 操作 唤醒
        try {
            //判断
            while (number != 1){
                con1.await();       //不该AAA干，AAA即当前线程等着
            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " + number);
            }
            //唤醒通知
            number = 2;     //修改标志位
            con2.signal();  //唤醒BB线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        // 判断 操作 唤醒
        lock.lock();
        try {
            while (number != 2){
                con2.await();       //不该AAA干，AAA即当前线程等着
            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " + number);
            }
            //唤醒通知
            number = 3;     //修改标志位
            con3.signal();  //唤醒CC线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        // 判断 操作 唤醒
        lock.lock();
        try {
            while (number != 3){
                con3.await();       //不该CCC干，AAA即当前线程等着
            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " + number);
            }
            //唤醒通知
            number = 1;     //修改标志位
            con1.signal();  //唤醒AA线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}