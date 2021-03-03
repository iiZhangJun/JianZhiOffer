package com.model;

public class Singleton {
    private static Singleton singleton ;
    private Singleton(){ }


    public Singleton newInstance(){  // 方法加synchronized
        if (singleton == null){
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cld = Singleton.class.getClassLoader();
        System.out.println(cld.loadClass("com.model.SingletonCAS"));
        System.out.println(cld);
        System.out.println(cld.getParent());
        System.out.println(cld.getParent().getParent());
    }

}
