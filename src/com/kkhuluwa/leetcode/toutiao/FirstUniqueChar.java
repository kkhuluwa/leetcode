package com.kkhuluwa.leetcode.toutiao;

public class FirstUniqueChar {


    public int fisrtUniqueChar(String s) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (s.indexOf(key) == s.lastIndexOf(s.charAt(key))) {
                return i;
            }
        }

        return index;
    }

    public int firstUniqueChar2(String s) {
        int index = -1;
        char[] count = new char[256];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < length; i++) {
            if (count[s.charAt(i)] == 1) {
                index = i;
                break;
            }
        }


        return index;
    }
}
