package com.juc;

public class Father {

    static ClassB  b = new ClassB(1);

    ClassA a2 = new ClassA(1);

    public Father(){
        System.out.println("父类构造函数初始化");
    }


}
