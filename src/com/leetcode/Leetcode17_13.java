package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 17.13 恢复空格
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 */
public class Leetcode17_13 {

    public int respace(String[] dictionary, String sentence) {
        if (dictionary.length==0 || dictionary==null) return sentence.length();
        if (sentence.length()==0) return 0;
        int dp[] = new int[sentence.length()];
        Set<Integer> lenSet = new HashSet<Integer>();
        Set<String> wordSet = new HashSet<String>();
        for (int i=0;i<dictionary.length;i++){
            lenSet.add(dictionary[i].length());
            wordSet.add(dictionary[i]);
        }
        for (int i=0;i<sentence.length(); i++){
            if (i==0) dp[i]=1;
            else dp[i]=dp[i-1]+1;
            for (Integer len : lenSet){
                if (i+1-len >= 0){
                    String word = sentence.substring(i+1-len,i+1);
                    if (wordSet.contains(word)){
                        if (i+1-len==0)
                            dp[i]=0;
                        else
                            dp[i] = Math.min(dp[i], dp[i-len]);
                    }
                }
            }
        }
        return dp[sentence.length()-1];
    }

    public static void main(String[] args) {
        String[] dic = new String[]{"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrotherxx";
        String[] dic2 = new String[]{"looked"};
        String sentence2 = "lookedlookedlooked";
        System.out.println(new Leetcode17_13().respace(dic2, sentence2));
    }
}
