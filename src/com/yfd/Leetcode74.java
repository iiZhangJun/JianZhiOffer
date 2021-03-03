package com.yfd;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class Leetcode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length-1;  // 行数
        int col = 0;  // 列数
        while (row >= 0 && col <= matrix[0].length-1){
            if (target < matrix[row][col])
                row--;
            else if (target > matrix[row][col])
                col++;
            else
                return true;
        }
        return false;
    }
}
