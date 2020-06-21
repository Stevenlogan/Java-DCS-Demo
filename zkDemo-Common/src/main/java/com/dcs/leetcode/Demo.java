package com.dcs.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Demo {

    public static void main(String[] args) {

    }

    //给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
    //解题思路 -- 将每个字符相加，最后得到的ASCII码之和相等则说明两个字符串的字符组成一致，可以重排列至相等
    public boolean CheckPermutation(String s1, String s2) {
        //思路分析：能重新排列后形成新字符串的前提 -- 1.字符串长度相等  2.两个字符串中的所有字符个数和值一一相等
        //1.长度不相等，返回false，无法重排列
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < c1.length; i++) {
            a += c1[i];
        }
        for (int i = 0; i < c2.length; i++) {
            b += c2[i];
        }
        if (a == b) {
            return true;
        }
        return false;
    }


    //solve 1 实现一个算法，不使用额外的数据结构，判断字符串中的每个字符是否都不相等
    public boolean q1(String str) {
        char[] strs = str.toCharArray();
        Set set = new HashSet();
        for (char c : strs) {
            set.add(c);
        }
        if (set.size() == strs.length) {
            return true;
        } else {
            return false;
        }
    }

    //solve 2 实现一个算法，不使用额外的数据结构，判断字符串中的每个字符是否都不相等
    public boolean q2(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }

}
