package com.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        MyCache cache = new MyCache(); //线程所要操纵的资源类
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                cache.put(String.valueOf(finalI), finalI);
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                cache.get(String.valueOf(finalI));
            },String.valueOf(i)).start();
        }
    }
}


//线程共享资源类
class MyCache {

    private final Map<String, Object> map = new HashMap<String, Object>();   //保证可见性加volatile
    private final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void put(String key, Object value){
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入： " + key);
            map.put(key, value);
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成 ");
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }
    }

    public void get(String key){
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成 ");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwlock.readLock().unlock();
        }
    }
}