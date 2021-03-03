package com.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();   //线程操作资源类
        new Thread(()->{
            phone.sendSMS();
        },"t1").start();

        new Thread(()->{
            phone.sendSMS();
        },"t2").start();

        TimeUnit.SECONDS.sleep(2);


        new Thread(phone,"t3").start();
        new Thread(phone,"t4").start();
    }
}

/**
 * 可重入锁，也叫递归锁
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *
 * Case one Synchronized 就是一个典型的可重入锁
 * t1	 invoked sendSMS  t1线程在外层方法获取锁的时候
 * t1	 #####invoked sendEmail  t1在进入内层方法会自动获取锁
 * t2	 invoked sendSMS
 * t2	 #####invoked sendEmail
 *
 * Case two ReentrantLock就是一个典型的可重入锁
 *
 *
 */

class Phone implements Runnable{

    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS");
        sendEmail();
    }

    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName() + "\t #####invoked sendEmail");
    }

    @Override
    public void run() {
        get();
    }
    Lock lock = new ReentrantLock();
    public void get(){
        lock.lock();
        // lock.lock();  同时加lock.lock()仍然会执行成功，只是要注意lock.lock()和lock.unlock()一一对应
        try {
            System.out.println(Thread.currentThread().getName() + "\t get");
            set();
        }finally {
            lock.unlock();  //lock.locak()加锁后，一定要记得lock.unlock()手动释放锁，否则其他线程无法获得该锁
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set");
        }finally {
            lock.unlock();
        }
    }

}