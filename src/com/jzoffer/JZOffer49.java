package com.jzoffer;

import java.util.HashMap;
import java.util.Map;

public class JZOffer49 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int begin = 0;
        map.put(s.charAt(0), 0);
        int[] dp = new int[s.length()];
        for(int i=1; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                begin = Math.max(begin, map.get(s.charAt(i)));
                dp[i] = i - begin;
                map.put(s.charAt(i), i);
            }else{
                map.put(s.charAt(i),i);
                dp[i] = dp[i-1]+1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
