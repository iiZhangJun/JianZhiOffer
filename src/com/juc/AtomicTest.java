package com.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019));
        System.out.println("current data:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024));
        System.out.println("current data:"+atomicInteger.get());
    }


}
