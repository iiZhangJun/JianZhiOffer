package com.model;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class SingletonCAS {

    private static SingletonCAS singleton = null;
    private static sun.misc.Unsafe UNSAFE;
    private static long ST_OFFSET;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe)field.get(null);
            ST_OFFSET = UNSAFE.objectFieldOffset(SingletonCAS.class.getDeclaredField("singleton"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private SingletonCAS(){ }

    public static SingletonCAS newInstance(){
        while (UNSAFE.getObjectVolatile(singleton, ST_OFFSET) == null){
            SingletonCAS st = new SingletonCAS();
            if (UNSAFE.compareAndSwapObject(singleton, ST_OFFSET, null, st)){
                break;
            }
        }
        return singleton;
    }
}
