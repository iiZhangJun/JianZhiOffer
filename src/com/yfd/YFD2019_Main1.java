package com.yfd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class YFD2019_Main1 {


    public static void main(String[] args) {
        System.out.println(Math.pow(10, 2));
        int n = 48;

        int b1 = 0;
        int b2 = 1;
        int ret = 0;
        for(int i=2;i<=n;i++){
            ret = (b1 + b2)%1000000007;
            b1 = b2;
            b2 = ret;
        }
        System.out.println(ret);



//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();  // 员工数
//        int n = sc.nextInt();  //车容量
//        int group = (int) Math.ceil((double)m/n);
//        //System.out.println(group);  //分3组
//        int[] employee = new int[m];
//        for (int i=0;i<m;i++){
//            employee[i] = sc.nextInt();
//        }
//
//        Queue<Integer> queue = null;
//        Stack<Queue<Integer>> stack = new Stack<>();
//        for (int i=0; i<m; i++){
//            if (i % n == 0){
//                queue = new LinkedList<>();
//                stack.push(queue);
//                queue.offer(employee[i]);
//            }else {
//                queue.offer(employee[i]);
//            }
//        }
//
//        while (!stack.isEmpty()){
//            Queue<Integer> qq = stack.pop();
//            while (!qq.isEmpty()){
//                System.out.print(qq.poll() + " ");
//            }
//        }
    }

}
