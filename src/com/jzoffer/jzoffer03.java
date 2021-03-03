package com.jzoffer;


import java.util.HashSet;
import java.util.Set;

public class jzoffer03 {

    // 时间复杂度 O(N) 空间复杂度 O(N)
    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    // 时间复杂度 O(N) 空间复杂度 O(1)

    /**
     * 数组中的数字都是在0~n-的范围内，如这个数组中没有重复的数字，当数组排序之后数字i将出现在下标为i的位置。
     * 由于数组中有重复数字，有些位置可能存在多个数字，同时有些位置可能没有数字。
     * 可重排数组，从头到尾依次扫描这个数组中的每个数字，当扫描到下标为i的数字时，首先比较这个数字(用m表示)是不是等于i。
     * 如果等于i，则接着扫描下一个元素；
     * 如果不是，则再拿它和第m个位置处数字进行比较，如果它和第m个数字相等，则找到一个重复数字。（该数字在下标为i和m的位置都出现了）
     * 如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m放到属于它的位置，然后重复比较，交换过程，直到发现一个重复数字。
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length){
            while (nums[i] != i){
                int m = nums[i];
                if (nums[i] == nums[m]){
                    return nums[i];
                }else {
                    nums[i] = m;
                    nums[m] = nums[i];
                }
            }
            i++;
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{6,4,5,0,0,2,3,4,5,6};
        System.out.println(jzoffer03.findRepeatNumber1(nums));
        System.out.println(jzoffer03.findRepeatNumber2(nums));
    }

}
