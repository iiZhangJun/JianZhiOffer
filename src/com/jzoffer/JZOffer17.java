package com.jzoffer;
import java.util.concurrent.locks.*;

/**
 * 17.打印从1到最大的n位数
 */
public class JZOffer17 {
    public int[] printNumbers(int n) {
        if (n==0) return new int[]{};
        int[] ans = new int[(int)Math.pow(10, n)];
        char[] number = new char[n];
        int index = 0;
        dfs(0, ans, number, n);
        return ans;
    }

    public void dfs(int curr, int[] ans, char[] number, int n){

        if (curr == n){
            if (saveNumber(number) !=-1 && saveNumber(number) !=0)
                System.out.println(saveNumber(number));
            return;
        }

        for (int i=0; i<10; i++){
            number[curr] = (char) ('0' + i);
            dfs(curr+1, ans, number, n);
        }
    }

    public int saveNumber(char[] number){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<number.length;i++){
            if (number[i] != '0')
                sb.append(number[i]);
            else if (sb.length()!=0)
                sb.append(number[i]);
        }
        if (sb.length()==0) return -1;
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        int[] ans = new JZOffer17().printNumbers(2);
    }
}
