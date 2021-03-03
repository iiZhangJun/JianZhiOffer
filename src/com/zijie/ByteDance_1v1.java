package com.zijie;

import java.util.*;

/**
 *  万万没想到之聪明的编辑
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 * 借用队列实现思路：
 * 当队列为空，添加指针所指向元素，
 * 如过列表中只有一个元素，比较该元素当前指针指向的元素是否相等，如相等，指针指向元素入队列， 指针++，如果不等，移除队列中的元素
 * 如果队列中此时存在两个元素，比较队尾元素和当前指针指向的元素是否相等，如相等，删掉指针指向的元素，队列中的元素全部出队列，指针++。如果不等，指针所指元素入队列
 *
 */
public class ByteDance_1v1 {

    public static String putRight(String str){
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();

        for (int i=0;i<str.length();i++){
            if (list.size()==0){        //列表为空时，加入当前指向元素，为让与下个元素比较
                list.add(str.charAt(i));
                if(i < str.length()-1)
                    sb.append(str.substring(i,i+1));
                else
                    sb.append(str.substring(i));
            }else if (list.size() == 1){        //列表中有一个元素时，与当前元素比较，如哦相等，将当前元素加入，指针++
                if (list.get(0)==str.charAt(i)){
                    list.add(str.charAt(i));
                } else {            // 若列表中存在的这个元素和当前指针指向元素不相等，则清空列表，指针++
                    list.clear();
                    list.add(str.charAt(i));
                }
                if(i < str.length()-1)
                    sb.append(str.substring(i,i+1));
                else
                    sb.append(str.substring(i));
            }else if (list.size() == 2){    //列表中有两个个元素时，说明这两个元素是相等的，
                    if (list.get(1)!=str.charAt(i)){    //将第二个元素与当前元素比较，如相等，删除当前指向元素，指针++  此处是用例优化处
                             //若第二个元素与当前元素比较，不相等，当前元素入列表，指针++
                        list.add(str.charAt(i));
                        if(i < str.length()-1)
                            sb.append(str.substring(i,i+1));
                        else
                            sb.append(str.substring(i));
                    }else {
                        list.remove(0);
                        list.add(str.charAt(i));
                    }
            }else if (list.size() == 3){
                if (list.get(2)!=str.charAt(i)){    //删除i指向的元素
                    list.clear();
                    list.add(str.charAt(i));
                    if(i < str.length()-1)
                        sb.append(str.substring(i,i+1));
                    else
                        sb.append(str.substring(i));
                }
            }
        }

            return sb.toString();
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            for (int i =0; i<n;i++){
                String str = sc.next();
                System.out.println(putRight(str));
            }
        }

    }
}
