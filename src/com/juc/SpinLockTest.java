package com.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 *自旋锁的好处：循环比较获取直到成功为止，没有类似wait的阻塞
 * 通过CAS操作完成自旋锁，A线程先进来调用myLocak方法自己持有锁5秒钟，
 * B线程随后进来发现当前有线程持有锁，不是Null, 所以只能通过自旋锁等待，直到A释放锁后B随后抢到
 */

public class SpinLockTest {

    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();//原子引用线程

    public  void myLock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)){

        }
        System.out.println(Thread.currentThread().getName() + "\t come in ");
        //自旋的本质CAS+while
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);    //自己解锁
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnLock");
    }

    public static void main(String[] args) {

        //线程操纵资源类
        SpinLockTest spinLockDemo = new SpinLockTest();

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                //暂停一会儿线程
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"AA").start();  // 先启动A线程

        try {
            TimeUnit.SECONDS.sleep(1);  //main线程等1s保证AA线程先启动
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockDemo.myLock();
            spinLockDemo.myUnLock();
        },"BB").start();

    }



}
