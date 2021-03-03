package com.oom;

/**
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at com.oom.StackOverflowOOM.newInstance(StackOverflowOOM.java:8)
 */

public class StackOverflowOOM {

    private static  void newInstance() {
        StackOverflowOOM oom = new StackOverflowOOM();
        newInstance();
    }

    public static void main(String[] args) {
        newInstance();
    }
}
