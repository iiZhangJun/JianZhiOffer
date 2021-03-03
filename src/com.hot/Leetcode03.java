package com.hot;
import	java.util.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class Leetcode03 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0 || s==null) return 0;
        if (s.length()==1) return 1;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        int maxLen = 0;
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                start = Math.max(start, map.get(s.charAt(i)));
                maxLen = Math.max(i-start+1, maxLen);
                map.put(s.charAt(i), i+1);
            }else {
                map.put(s.charAt(i), i+1);
                maxLen = Math.max(i-start+1, maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode03().lengthOfLongestSubstring("ab"));
        System.out.println(new Leetcode03().lengthOfLongestSubstring("abfdvdgfk"));
        System.out.println(new Leetcode03().lengthOfLongestSubstring("ccc"));
    }
}
