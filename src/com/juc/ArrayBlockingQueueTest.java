package com.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        new Thread(()->{
            try {
                blockingQueue.offer("a", 2, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName()+"\t put a");
                blockingQueue.offer("b", 2, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName()+"\t put b");
                blockingQueue.offer("c", 2, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName()+"\t put c");
                //设置超时退出阻塞，线程AAA在offer a b c三元素时因阻塞队列未满，因此无需阻塞，直接可offer成功
                //当offer d元素时，阻塞队列已满，在阻塞2s后若队列仍满则退出，offer返回false表示入队列失败，即put d失败
                blockingQueue.offer("d", 2, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName()+"\t put d " + blockingQueue.offer("d", 2, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
    }

    public static void block() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        new Thread(()->{
            try {
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName()+"\t put a");
                blockingQueue.put("b");
                System.out.println(Thread.currentThread().getName()+"\t put b");
                blockingQueue.put("c");
                System.out.println(Thread.currentThread().getName()+"\t put c");
                blockingQueue.put("d");
                System.out.println(Thread.currentThread().getName()+"\t put d");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        //线程B不take时， 线程A在执行到put("d")会一直被阻塞，直到线程B take走一个元素，队列不满时，线程A继续执行，若不取则一直阻塞不能继续
        new Thread(()->{
            try {
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"\t take a");
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"\t take b");
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"\t take c");
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"\t take d");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }

    public static void test01() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);    //容量为3的数组有界阻塞队列
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        //blockingQueue.add("d");   会抛出java.util.IllegalStateException:Queue full
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        // blockingQueue.remove();  会抛出java.util.NoSuchElementException
    }
}
