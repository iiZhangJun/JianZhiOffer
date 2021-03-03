package com.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    //人到齐才开会 ++
    public static void main(String[] args) {
        CyclicBarrier cyclicBar = new CyclicBarrier(6, ()->{
            System.out.println("***召唤神龙");
        });
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"\t 来到会议室");
                    cyclicBar.await();
                    //等着  被阻塞等待，人到齐了才开会 先到的被阻塞 不继续下一步 直到达到设置值
                    //System.out.println(Thread.currentThread().getName()+"\t 人到齐才执行"); 这句话最终才会被执行。人都到齐开会时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
