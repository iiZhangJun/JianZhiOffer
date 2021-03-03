package com.jzoffer;

import java.util.Arrays;

public class JZOffer46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i=1; i<s.length();i++){
            dp[i] = dp[i-1];
            int t = (s.charAt(i-1) - '0')*10 + s.charAt(i)-'0';
            if ( t <= 25 && t >=10){
                if (i-2 < 0){
                    dp[i] +=1;
                    continue;
                }
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        char[] c = new char[]{'a','b','c'};
        System.out.println(Arrays.toString(c));

        int num = 11234;
        System.out.println(new JZOffer46().translateNum(num));


    }




}
