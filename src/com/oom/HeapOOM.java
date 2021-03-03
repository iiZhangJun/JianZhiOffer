package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出Demo
 * VM参数设置：-Xms20m -Xmx32m -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=/temp/heapdump.hprof
 * java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to java_pid12296.hprof ...
 * Heap dump file created [40955606 bytes in 0.446 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        long i=200000;
        while (i-->0){
            list.add(new OOMObject());
        }
    }
    static class OOMObject {}
}
