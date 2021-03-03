package com.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile/CAS/AtomicIntefer/BlockingQueue/
 * 注：此方法使用AtomicInteger保证了数据一致性，以及使用BlockingQueue自动维持了线程的阻塞和唤醒
 */
public class ProducerCunsumer_BlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);
        MyResource myResource = new MyResource(blockingQueue);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Producer1").start();

//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
//            try {
//                myResource.myProd();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },"Producer2").start();
//
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
//            try {
//                myResource.myConsumer();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },"Consumer1").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer2").start();



        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板main线程叫停");
        //myResource.stop();
    }
}


class MyResource {
    private volatile boolean FLAG = true;   //多线程默认要volatile，保证可见性，一个线程修改掉FLAG，及时通知到其他线程，
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    BlockingQueue<String> blockingQueue = null;
    Lock lock = new ReentrantLock();
    //参数传接口，足够抽象，保证高可用性和扩展性，实际使用落地传参可传具体是实现类

    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName()); //反射
    }

    public void myProd() throws Exception{
            String data = null;
            boolean retValue ;
            while (FLAG){
                data = atomicInteger.incrementAndGet()+"";
                retValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (retValue){
                    System.out.println(Thread.currentThread().getName()+"\t 插入队列 " + data+" 成功");
                }else {
                    System.out.println(Thread.currentThread().getName()+"\t 插入队列 " + data+" 失败");
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(Thread.currentThread().getName()+"\t 生产工作结束 ");
    }

    public void myConsumer() throws InterruptedException {
//        lock.lock();
//        try {
            String result = null;
            while (FLAG) {
                result = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (result == null || result.equalsIgnoreCase("")) {
                    FLAG = false;   //消费者要停止消费了
                    System.out.println();
                    System.out.println();
                    System.out.println(Thread.currentThread().getName() + "\t 超过2s没有消费到蛋糕，退出");
                    System.out.println("消费线程结束");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "\t 消费者消费蛋糕" + result + "成功");
            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
    }

    public void stop(){
        this.FLAG = false;
    }
}