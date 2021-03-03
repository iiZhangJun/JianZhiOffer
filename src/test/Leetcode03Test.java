package test;

import com.hot.Leetcode03;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leetcode03Test {

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, new Leetcode03().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, new Leetcode03().lengthOfLongestSubstring("bbbb"));
        assertEquals(3, new Leetcode03().lengthOfLongestSubstring("dvdf"));
    }
}