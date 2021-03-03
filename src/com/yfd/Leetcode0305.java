package com.yfd;

import java.util.Stack;

/**
 * 03.05 排序栈
 * 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 *
 */
public class Leetcode0305 {

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.pop();
        stack.pop();
        stack.push(1);
        stack.push(6);
//        stack.push(0);
//        stack.push(7);
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
        while (!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}

class SortedStack {

    Stack<Integer> stack;
    Stack<Integer> temp = new Stack<>();

    public SortedStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || val <= stack.peek() )
            stack.push(val);
        else {
            while (!stack.isEmpty() && val > stack.peek()){
                temp.push(stack.pop());
            }
            stack.push(val);
            while (!temp.isEmpty()){
                stack.push(temp.pop());
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
    }

    public int peek() {
        if(stack.isEmpty())
            return -1;
        else
            return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && temp.isEmpty();
    }
}

