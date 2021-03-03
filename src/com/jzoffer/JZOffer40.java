package com.jzoffer;

/**
 * 40 最小的k个数
 */
public class JZOffer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || k > arr.length || k <= 0) return new int[]{};
        int start = 0;
        int end = arr.length-1;
        int index = partition(arr, start, end);
        while (index != k){
            if (index > k){
                end = index-1;
                index = partition(arr, start, end);
            }else {
                start = index+1;
                index = partition(arr, start, end);
            }
        }
        int[] ret = new int[k];
        System.arraycopy(arr, 0, ret, 0, k);
        return ret;
    }

     public int partition(int[] arr, int start, int end){
        int piviot = arr[start];
        int begin = start;
        start = start+1;
        while (start <= end){
            if (arr[start] > piviot){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                end--;
            }else {
                start++;
            }
        }
         int temp = arr[end];
         arr[end] = piviot;
         arr[begin] = temp;
         return end;
     }

    public static void main(String[] args) {

        int[] input = new int[]{4,5,7,2,3,0,15,9,7,6,8,5};
        int k = 8;
        int[] output = new JZOffer40().getLeastNumbers(input, k);
        for (int i=0;i<k;i++){
            System.out.println(output[i]);
        }
    }




}
