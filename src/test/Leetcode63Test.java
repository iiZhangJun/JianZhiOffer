package test;

import com.leetcode.Leetcode63;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leetcode63Test {

    @Test
    void uniquePathsWithObstacles() {

        int[][] arr = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        Assertions.assertEquals(2, new Leetcode63().uniquePathsWithObstacles(arr));
        int[][] arr2 = new int[][]{{1,0,0},{0,1,0},{0,0,0}};
        Assertions.assertEquals(0, new Leetcode63().uniquePathsWithObstacles(arr2));
        int[][] arr3 = new int[][]{{0,0,0},{0,1,0},{0,0,1}};
        Assertions.assertEquals(0, new Leetcode63().uniquePathsWithObstacles(arr3));
    }

    @Test
    void uniquePathsWithObstacles_dp() {
        int[][] arr = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        Assertions.assertEquals(2, new Leetcode63().uniquePathsWithObstacles_dp(arr));
        int[][] arr2 = new int[][]{{1,0,0},{0,1,0},{0,0,0}};
        Assertions.assertEquals(0, new Leetcode63().uniquePathsWithObstacles_dp(arr2));
        int[][] arr3 = new int[][]{{0,0,0},{0,1,0},{0,0,1}};
        Assertions.assertEquals(0, new Leetcode63().uniquePathsWithObstacles_dp(arr3));
        int[][] arr4 = new int[][]{{1}};
        Assertions.assertEquals(0, new Leetcode63().uniquePathsWithObstacles_dp(arr4));
    }
}