package com.kkhuluwa.leetcode.toutiao;

public class Reverse {


    /**
     * 给予字符串是类似于网址：www.baidu.com    www.sina.com.cn
     * 将给与的字符串按照规则反转 com.baidu.www    cn.com.sina.www
     *
     * @param str
     * @return
     */
    public static String allRotate(String str) {
        int strLength = str.length();
        char[] chars = str.toCharArray();
        // 整体反转
        Rotate(chars, 0, strLength - 1);
        System.out.println("!!!!!!!");
        System.out.println(new String(chars));
        System.out.println(".......");


        int left = 0;
        // 先局部反转
        for (int i = 0; i < strLength; i++) {
            if (chars[i] == '.'  || chars[i] == '/') {
                Rotate(chars, left, i - 1);
                System.out.println("!!!!!!!");
                System.out.println(new String(chars));
                System.out.println(".......");
                left = i + 1;
            }
        }
        Rotate(chars, left, strLength - 1);  // 最后一小段反转


        return new String(chars);
    }

    public static void Rotate(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "www.baidu.com.cn/a/b/";
        System.out.println(allRotate(str));

    }


}
