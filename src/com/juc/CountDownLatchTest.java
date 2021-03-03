package com.juc;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.xml.bind.Element;
import java.util.concurrent.CountDownLatch;

/**
 * 倒计时，火箭发射，或者一国国逐灭，统一灭亡 --
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                 countDownLatch.countDown();
                 System.out.println(Thread.currentThread().getName() + " 国灭亡");
            }, CountEnum.getElement(i).getRetMsg()).start();
        }
        countDownLatch.await();
        System.out.println("***秦统一六国");
    }
}

//枚举。想个迷你数据库，每个枚举是个小表或小记录
enum CountEnum {

    ONE(0,"赵", true), TWO(1,"魏", true),
    THREE(2,"燕", true), FOUR(3,"韩", true),
    FIVE(4,"楚", true), SIX(5,"孟", true);

    private int retcode;
    private String retMsg;
    private boolean retBoolean;

    CountEnum(int retcode, String retMsg, boolean retBoolean) {
        this.retcode = retcode;
        this.retMsg = retMsg;
        this.retBoolean = retBoolean;
    }
    public int getRetcode() { return retcode; }

    public String getRetMsg() {
        return retMsg;
    }
    public boolean isRetBoolean() {return retBoolean; }

    public static CountEnum getElement(int code){
        for (CountEnum element : CountEnum.values()){
            if (code == element.getRetcode())
                return element;
        }
        return null;
    }





}
