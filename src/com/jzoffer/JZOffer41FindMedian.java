package com.jzoffer;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */

public class JZOffer41FindMedian {
    PriorityQueue<Integer> queue1;  //左区间 大根堆
    PriorityQueue<Integer> queue2; //右区间  小根堆
    static int sum;

    public JZOffer41FindMedian() {
        queue1 = new PriorityQueue<>(((v1,v2)->v2-v1));
        queue2 = new PriorityQueue<>(((v1,v2)->v1-v2));
        sum = 0;
    }

    public void addNum(int num) {
        if (sum % 2 == 0){ // 若当前数据结构中已读取了sum为偶数个数据，奇数个装到左区间
            queue1.offer(num);
        }else {
            queue2.offer(num);
        }
        if (!queue1.isEmpty() && !queue2.isEmpty() && queue1.peek() > queue2.peek()){
            queue1.offer(queue2.poll());
            queue2.offer(queue1.poll());
        }
        sum++;
    }

    public double findMedian() {
        if (sum % 2 == 1 && !queue1.isEmpty()){ //奇数个
            return (double) queue1.peek();
        }else {
            return (queue1.peek() + queue2.peek()) / 2.0;
        }
    }
}
