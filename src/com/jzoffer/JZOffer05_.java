package com.jzoffer;

/**
 * 两个排序数组A1和A2，内存在A1的末尾有足够多事务空余时间容纳A2，
 * 将A2中的所有数字插入A1中，并且所有数字是排序的。
 */
public class JZOffer05_ {

    public static int[] insert(int[] a1, int[] a2, int lena1){
        // pos指针定位
        int pos = lena1+a2.length-1;        //指向最后一个填充位置
        int posa1 = lena1-1;        //指向a2当前比较元素
        int posa2 = a2.length-1;    //指向a1当前比较元素
        while (posa1 >= 0 && posa2 >= 0 && pos >= 0){
            if (a1[posa1] > a2[posa2]){
                a1[pos] = a1[posa1];
                posa1--;
                pos--;
            }else {
                a1[pos] = a2[posa2];
                posa2--;
                pos--;
            }
        }
        while (posa1 <0 && posa2 >=0 && pos >= 0){
            a1[pos] = a2[posa2];
            posa2--;
            pos--;
        }
        return a1;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{0,2,3,8,10,0,0,0,0};
        int[] a2 = new int[]{1,4,5,9};
        int[] a = JZOffer05_.insert(a1, a2, 5);
        for (int i=0; i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();

    }

}
