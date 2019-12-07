package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 实现一个函数，吧字符串中的所有空格替换成 %20
 * @Date: Created in 2019/12/7 16:43
 */
public class Question5 {
    public static void main(String[] args) {
        System.out.println(replace("We are happy!"));
    }

    public static String replace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
               sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
