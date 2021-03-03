package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 两个线程，一个是main线程，一个是AAfutureTask1
        FutureTask<Integer> futureTask1 = new FutureTask<Integer> (new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<Integer> (new MyThread());
        new Thread(futureTask1, "AA").start();
        // new Thread(futureTask1, "BB").start();  要注意一个FutureTask对象只能代表一个任务线程，同样动作
        new Thread(futureTask2, "BB").start();
        System.out.println("----main----");
//        while (!futureTask1.isDone()){   //futuretask这个任务什么时候执行完什么时候main执行下一步
//          //表示什么时候算完什么时候取结果
//        }
        int result = futureTask1.get(); //没遇到get算着，遇到get算完可取到，没算完就等着直到算完。
        //futureTsk.get语句最好放在最后，要求获得callable线程的计算结果，
        // 如果没有计算完成就要去强求，会导致堵塞，直到计算完成，所以最好每次放在最后

        System.out.println(result + 100 );
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "---come in com.juc.MyThread---");
        return 1024;
    }
}