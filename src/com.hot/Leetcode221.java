package com.hot;

/**
 * 221 最大正方形 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class Leetcode221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0 || matrix == null) return 0;
        int maxEdge = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i<matrix.length;i++){
            dp[i][0] = matrix[i][0]-'0';
            maxEdge = Math.max(maxEdge, dp[i][0]);
        }
        for (int i = 0; i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i]-'0';
            maxEdge = Math.max(maxEdge, dp[0][i]);
        }

        for (int i = 1; i<matrix.length;i++){
            for (int j =1; j<matrix[0].length;j++){
                if (matrix[i][j]=='0') {
                    dp[i][j]=0;
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }
        return (int) Math.pow(maxEdge, 2);
    }


}
