package com.yfd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode56 {



    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        //1.排序
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        //2. 比较
        for (int i=1; i<intervals.length;i++){
            if (list.get(list.size()-1)[1]>=intervals[i][0]){
                int right = Math.max(list.get(list.size()-1)[1], intervals[i][1]);
                //int left = Math.min(list.get(list.size()-1)[0], intervals[i][0]);
                list.set(list.size()-1, new int[]{list.get(list.size()-1)[0], right});
            }else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int intervals[][] = new int[][]{{1,3},{1,6},{6,10},{15,18}};
        int[][] res = new Leetcode56().merge(intervals);
        for (int i=0;i<res.length; i++){
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}
