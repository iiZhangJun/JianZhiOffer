package com.oom;

/**
 * VM OPTIONS:-XX:PermSize=6m -XX:MaxPermSize=6m 或 -XX:MaxMetaspaceSize=6m
 * 在JDK7及以上版本，原本存放在方法区中的字符串常亮池被移到Java堆中，由java大小限制。-Xmx6m
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */

import java.util.HashSet;
import java.util.Set;

public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        long i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
