package com.leetcode;

import java.util.Arrays;

/**
 * 32.给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class Leetcode32h {

    public int longestValidParentheses(String s) {
        if (s.length()==0 || s==null) return 0;
        int dp[] = new int[s.length()]; //dp[i]表示以i结尾的最长有效括号字串
        dp[0]=0;
        int max = 0;
        for (int i=1; i<s.length(); i++){
            if (s.charAt(i)=='(')
                dp[i] = 0;
            else if (s.charAt(i)==')')
                if (s.charAt(i-1)=='(')
                    if (i-2 < 0)
                        dp[i] = 2;
                    else
                        dp[i] = 2 + dp[i-2];
                else if (s.charAt(i-1)==')')
                    if (i-dp[i-1]-2 >= 0 && s.charAt(i-dp[i-1]-1)=='(')
                        dp[i] = 2 + dp[i-1] + dp[i-dp[i-1]-2];
                    else if (i-dp[i-1]-2 < 0 && i-dp[i-1]-1 >=0 && s.charAt(i-dp[i-1]-1)=='(')
                        dp[i] = 2 + dp[i-1];
                    else
                        dp[i] = 0;
            max = Math.max(max, dp[i]);
            //System.out.println(dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        String s0 = "((((()))))()()()()()";
        String s1 = "(())()";
        String s2 = "()))";
        System.out.println(new Leetcode32h().longestValidParentheses(s0));
    }
}
