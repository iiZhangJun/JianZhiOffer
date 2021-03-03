package com.leetcode;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class yfd_Leetcode189 {
    //暴力解法
    public void rotate1(int[] nums, int k) {
        if (nums==null||nums.length ==0||k==0) return;
        for(int i=0;i<k;i++){
            int temp = nums[0];
            nums[0]=nums[nums.length-1];
            for (int j=nums.length-2;j>0;j--){
                nums[j+1]=nums[j];
            }
            nums[1]=temp;
        }
    }

    // 反转法
    public void rotate2(int[] nums, int k) {
        if (nums==null||nums.length ==0||k==0) return;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
       while (start < end){
           int temp = nums[start];
           nums[start]=nums[end];
           nums[end]=temp;
           start++;
           end--;
       }
    }




    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k=3;
        new yfd_Leetcode189().rotate1(nums, k);
        for (int i=0;i<nums.length;i++)
            System.out.println(nums[i]);
        System.out.println("------------");
        int k2=4;
        new yfd_Leetcode189().rotate2(nums, k2);
        for (int i=0;i<nums.length;i++)
            System.out.println(nums[i]);

    }
}
