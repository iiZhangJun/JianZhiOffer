package com.leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

 */
public class Leetcode714 {

    public int maxProfit(int[] prices, int fee) {
        if (prices==null || prices.length==0) return 0;
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;   //表示第0天结束未持股
        dp[0][1] = -prices[0];   //表示第0天结束持有一支股
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }

    public static void main(String[] args) {
        int[] prices= new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new Leetcode714().maxProfit(prices, fee));
    }
}
