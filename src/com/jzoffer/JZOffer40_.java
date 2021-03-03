package com.jzoffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 40.最小的k个数 大根堆
 */
public class JZOffer40_ {

    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>((v1,v2)-> v2-v1);
        for (int i =0;i<arr.length;i++){
            if (queue.size()<k){
                queue.offer(arr[i]);
            }else {
                if (queue.peek() > arr[i]){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int[] ret = new int[queue.size()];  //或者k
        for (int i=0;i<k;i++){
            ret[i] = queue.poll();
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] input = new int[]{4,5,7,2,3,0,15,9,7,6,8,5};
        int k = 8;
        int[] output = new JZOffer40_().getLeastNumbers(input, k);
        for (int i=0;i<k;i++){
            System.out.println(output[i]);
        }
    }
}
