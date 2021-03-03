package com.jzoffer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class JZOffer38 {

    public String[] permutation(String s) {
        if(s==null || s.length()==0) return new String[]{};
        char[] ch = s.toCharArray();
        Set<String> ret = new HashSet<>();
        helper(ret, ch, 0);
        String[] ans = new String[ret.size()];
        int flag = 0;
        Iterator<String> it = ret.iterator();
        while(it.hasNext()){
            ans[flag] = it.next();
            flag++;
        }
        return ans;
    }

    private void helper(Set<String> ans, char[] s, int index){
        if (index == s.length-1){
            ans.add(new String(s));
            return;
        }
        for (int i=index; i < s.length; i++){
            swap(s, i, index);
            helper(ans, s, index+1);
            swap(s, i, index);
        }
    }

    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        String[] ans = new JZOffer38().permutation(s);
        for (String st:ans){
            System.out.println(st);
        }

    }


}
