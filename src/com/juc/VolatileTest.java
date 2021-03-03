package com.juc;

import	java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.验证volatile的可见信
 * 1.1假设int age=0；age之前根本没有添加volatile关键字修饰，没有可见性
 * 1.2添加volatile,可以解决可见性问题
 * 2.验证volatile不保证原子性
 * 2.1 什么是原子性？
 *    不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被阻塞或者被分割，需要整体完整
 *    要么同时成功，要么同时失败
 * 2.2 volatile 不保证原子性的案例演示
 * 2.3 volatile 不保证原子性
 * 2.4 如何解决原子性？
 *      1.加Synchronized关键字
 *      2.使用我们的juc 下 AtomicInteger等
 *      **/
public class VolatileTest {

    public static void main(String[] args) {
        Student stu = new Student();    //资源类
        for(int i=1;i<=20;i++){
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++){
                    stu.addPlusPlus();
                    stu.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }
        //需要等待上面20个线程都全部计算完成，再用main线程取得最终的结果值看是多少？
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        //结果少于20000，因为volatile不保证原子性，出现写值丢失
        System.out.println(Thread.currentThread().getName()+"\t finally number value:" + stu.age);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger finally number value:" + stu.atomicInteger);
    }
    // volatile保证可见性，及时通知其他线程，主物理内存的值已经被修改
    public static void seeOkByVolatile() {
        Student stu = new Student();    //资源类

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(1);
                stu.addTo37();
                System.out.println(Thread.currentThread().getName()+"\t update age:"+stu.age);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "AAA").start();

        while (stu.age==0){
            //main线程一直再这里等待循环，直到age值不再等于0
        }
        System.out.println(Thread.currentThread().getName()+"\t mission over, current age:"+stu.age);
    }
}


class Student {
    volatile int age = 0;
    //int age = 0;
    public void addTo37() {
        this.age = 37;
    }
    //请注意，此时的age变量前面修饰了volatile关键字的，volatile不保证原子性
    // 若此方法加Synchronized关键字，则可保证原子性，但Synchronized效率很低，重量级锁
    //age++底层是三个指令的
    // getField拿到原始值
    // iadd进行加1操作
    // 执行putField写 把累加后的值写回 此时出现ns级别的时间差，写值覆盖，将写值丢失 线程争抢太快
    // （volatile只保证可见性，不保证原子性）
    public void addPlusPlus(){
        age++;
    }

    AtomicInteger atomicInteger = new AtomicInteger(0); //带原子性的age++
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}