package com.model;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import	java.sql.Types;

public class Main {
    static void pong(){
        System.out.print("YY");
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Thread t = new Thread(){
            public void run(){
                pong();
            }
        };
        t.run();
        System.out.println("JO");

        System.out.println(100.0);
        System.out.println(Integer.toBinaryString(202));
        System.out.println(Integer.toBinaryString(116));
        System.out.println(Integer.toBinaryString(108));
        System.out.println(Integer.toBinaryString(168));
        String str = "java开发";
        System.out.println(str.getBytes("UTF-8").length);
        System.out.println(0^1);
        check(null);
        String s = "lllll";
        s = s.replace(s.substring(0,2),"q");
        System.out.println(s);
        String st = "good";
        char[] ch = new char[]{'a','b','c'};
        change(st, ch);
        System.out.println(st);
        System.out.println(ch);


        String a = "123";
        String b = a.intern();
        String c= new String("123");
        String d= "123";
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
    }

    public static void check(Object arg){
        System.out.println("check1");
    }
    public static void change(String str, char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }
    public static void check(String arg){
        System.out.println("check2");
    }

}
