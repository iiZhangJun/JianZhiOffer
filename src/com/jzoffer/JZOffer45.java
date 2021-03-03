package com.jzoffer;

import java.util.Arrays;
import java.util.Comparator;

public class JZOffer45 {

    public String minNumber(int[] nums) {
        if (nums==null || nums.length==0) return null;
        String[] ss = new String[nums.length];
        for(int i=0;i<ss.length;i++){
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<ss.length;i++){
            sb.append(ss[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{333, 4, 5, 555, 201};
        System.out.println(new JZOffer45().minNumber(nums));
    }
}
