package com.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类线程不安全
 * ArrayList
 * HashSet
 * HashMap
 */
public class ContainerNotSafeTest {

    public static void arrayListNotSafe(){
        //List<String> list = new ArrayList();   ArrayList线程不安全
        //List<String> list = new Vector();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i=0;i<30; i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }, "list"+String.valueOf(i)).start();
        }
    }

    public static void hashSetNotSafe(){
        //  Set<String> set = new HashSet<>();  HashSet线程不安全
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<String>();        //底层仍然是创建new 一个CopyOnWriteArrayList<>();
        for (int i=0;i<30; i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString());
                System.out.println(set);
            }, "set"+String.valueOf(i)).start();
        }
        // HashSet底层是HashMap,但add的时候HashSet.add只需要传一个参数，
        // 实际上底层调用的依然是map.put(e, PRESENT)，
        // 只不过这个value被传入一个static final objetc PRSENT=new Object()，是一个常量而已
    }

    public static void hashMapNotSafe(){
        // Map<String, String> map = new HashMap<>();  HashMap线程不安全解决方案2种
        // Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i=0;i<30; i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(map);
            }, "set"+String.valueOf(i)).start();
        }
    }

    public static void main(String[] args) {

    }
    /**
     * 故障现象：
     *      java.util.ConcurrentModificationException
     *
     * 导致原因：
     *      并发争抢修改导致，参考花名册签名举例情况
     *      一个人正在写入，另一个同学过来抢夺，导致数据不一致异常，并发修改异常
     * 解决方案：
     *      1. new Vector<>()   vector加了synchronized关键字
     *      2.Collections.synchronizedList(new ArrayList<>());
     *      3.new CopyOnWriteArrayList<>();   写时复制ArrayList
     *
     * 优化建议： ArrayList
     * CopyOnWriteArrayList 读写分离的思想,读在当前对象读，写时复制一个新对象过来写，并将所有引用指向新对象
     * HashMap另作说明，ConcurrentHashMap
     */
}
