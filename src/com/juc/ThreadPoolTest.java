package com.juc;

import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        int cpunum = Runtime.getRuntime().availableProcessors();
        System.out.println(cpunum); //8
        ExecutorService threadPool = new ThreadPoolExecutor(3,
                                                            cpunum+1,
                                                            2,
                                                             TimeUnit.SECONDS,
                                                             new LinkedBlockingQueue<>(6),
                                                             Executors.defaultThreadFactory(),
                                                             new ThreadPoolExecutor.DiscardOldestPolicy());
        // new ThreadPoolExecutor.AbortPolicy()  有效任务数 maxmimumPoolSize+阻塞队列可容纳任务数，超过抛异常中断
        // new ThreadPoolExecutor.CallerRunsPolicy() 既不丢弃任务也不会抛异常，而是将某些任务回退到调用者处理，如mian线程，从而降低新任务的流量
        // new ThreadPoolExecutor.DiscardPolicy() 直接丢弃多余出来无法处理的任务，即不予任何处理也不抛出异常
        // new ThreadPoolExecutor.DiscardOldestPolicy() 抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务
       for (int i = 0; i < 17; i++) {
           int finalI = i;
           threadPool.execute(()->{
               System.out.println(Thread.currentThread().getName() +"\t 执行任务 " + finalI);
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
       }
       threadPool.shutdown();
    }
}
