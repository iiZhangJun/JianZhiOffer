package com.jdk.base;

public class StringDemo {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s3 == s1); //只要new创建对象都会开辟新空间
        System.out.println(s3 == s4);  //比较的是地址
        System.out.println(s3.equals(s4));
    }
}
