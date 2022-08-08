package com.kkhuluwa.leetcode.toutiao;

public class Count {
    public static int getLastPersonNum(int n) {
        int index;
        int[] person = new int[n + 1];
        int num = 0; // 模拟 1-3
        int dead = 0; // 模拟退出人数
        // 对最初的数字进行标号
        for (int i = 0; i <= n; i++) {
            person[i] = i;
        }
        for (int i = 0; ; i++) {
            if (i > n) {
                i = 1;
                // 数据越界了 重置
            }


            if (dead == n - 1) {

                index = i;
                break;
            }
            if (person[i] != 0) {
                num++;
            }

            if (num == 3) {
                person[i] = 0;
                num = 0;
                dead++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(getLastPersonNum(3));
    }
}
