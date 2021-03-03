package com.leetcode;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 * 等差数列
 */
public class Leetcode16_11 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k==0) return new int[]{};
        if (shorter==longer) return new int[]{shorter*k};
        int[] retArr = new int[k+1];
        retArr[0]=k*shorter;
        for (int i=1;i<=k;i++){
            retArr[i]=retArr[i-1]+(longer-shorter);
        }
        return retArr;
    }

    public static void main(String[] args) {
        int[] retArr = new  Leetcode16_11().divingBoard(5,8,3);
        for (int i=0;i<retArr.length;i++){
            System.out.println(retArr[i]);
        }
    }
}


