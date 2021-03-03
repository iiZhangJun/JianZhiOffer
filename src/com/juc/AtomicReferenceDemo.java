package com.juc;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User z3 = new User("z3", 22);
        User li4 = new User("li4", 18);
        AtomicReference<User> atomicReference = new AtomicReference<> ();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4) + " current user:" + atomicReference.get().username);
        System.out.println(atomicReference.compareAndSet(z3, li4) + " current user:" + atomicReference.get().username);

    }

}

class User{
    String username;
    int age;

    public User(String username, int age){
        this.username = username;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }
}