package com.jzoffer;

public class JZoffer05 {

    // 空间复杂度 O(N) 时间复杂度 O(N)
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = " ";// s="we are happy!  ";
        System.out.println(JZoffer05.replaceSpace(s));
    }

}
