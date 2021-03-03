package com.leetcode;

import	java.util.Scanner;

/**
 * 174 地下城游戏
 */
public class Leetcode174 {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null||dungeon.length ==0) return 0;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dp.length-1][dp[0].length-1] = Math.max(1-dungeon[dungeon.length-1][dungeon[0].length-1], 1);    //特别注意
        for (int i=dp.length-2;i>=0;i--){
            dp[i][dp[0].length-1] = Math.max(dp[i+1][dp[0].length-1]-dungeon[i][dp[0].length-1], 1);
        }
        for (int i=dp[0].length-2;i>=0;i--){
            dp[dp.length-1][i] = Math.max(dp[dp.length-1][i+1]-dungeon[dp.length-1][i], 1);
        }
        //dp[i][j]表示从第i，j个位置到终点所需的最少健康点数 dp[i][j]= max(min(dp[i+1][j],dp[i][j+1])-duigong[i][j],1)
        for (int i=dungeon.length-2; i >= 0; i--){
            for (int j = dungeon[0].length-2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j], 1);
            }
        }

        for (int i=0;i<dp.length;i++){
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"");
            }
            System.out.println();
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] dungeon= new int[m][n];
        for (int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                dungeon[i][j] = sc.nextInt();
            }
        }
        System.out.println(new Leetcode174().calculateMinimumHP(dungeon));
    }


}
