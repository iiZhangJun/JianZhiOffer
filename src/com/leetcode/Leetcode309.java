package com.leetcode;
import	java.util.Properties;

/**
 * 309 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 动态规划：
 * f[i][0]表示第i天结束之后持有一只股票
 * f[i][1]表示第i天结束之后不持股且处于冷冻期
 * f[i][2]表示第i天结束之后不持股且不处于冷冻期
 */
public class Leetcode309 {

    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0) return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][0], Math.max(dp[prices.length-1][1], dp[prices.length-1][2]));
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(new Leetcode309().maxProfit(prices));
    }
}
