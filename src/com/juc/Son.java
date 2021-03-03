package com.juc;

public class Son extends Father{

    static ClassB  b = new ClassB(2);

    ClassA a = new ClassA(2);

    public Son(){
        System.out.println("子类构造函数初始化");
    }
}
