package com.oom;

import java.util.Scanner;

/**
 * VM参数设置  -Xmx20m -XX:MaxDirectMemorySize=10m
 * Exception in thread "main" java.lang.OutOfMemoryError
 * 	at sun.misc.Unsafe.allocateMemory(Native Method)
 * 	at com.oom.DirectMemoryOOM.main(DirectMemoryOOM.java:15)
 */
public class DirectMemoryOOM {
    private static final int _1mb = 1024*102;
    public static void main(String[] args) throws IllegalAccessException {

//        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//        unsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
//        while (true){
//            unsafe.allocateMemory(_1mb);
//        }
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = new String(sc.next());
        }

    }
}
