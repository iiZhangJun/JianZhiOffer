package com.jzoffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityTest {


    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(((v1,v2)->v1-v2));  // 维持一个小根堆，队首元素值最小
        queue.offer(3);
        queue.offer(5);
        queue.offer(9);
        queue.offer(0);
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
    }
}
