package test;

import com.hot.Leetcode221;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leetcode221Test {


    @Test
    void maximalSquare() {
        char[][] matrix = {{'0','1'}};
        assertEquals(1, new Leetcode221().maximalSquare(matrix));

    }
}