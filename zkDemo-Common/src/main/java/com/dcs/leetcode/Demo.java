package com.dcs.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Demo {

    public static void main(String[] args) {

    }

    //���������ַ��� s1 �� s2�����дһ������ȷ������һ���ַ������ַ��������к��ܷ�����һ���ַ�����
    //����˼· -- ��ÿ���ַ���ӣ����õ���ASCII��֮�������˵�������ַ������ַ����һ�£����������������
    public boolean CheckPermutation(String s1, String s2) {
        //˼·���������������к��γ����ַ�����ǰ�� -- 1.�ַ����������  2.�����ַ����е������ַ�������ֵһһ���
        //1.���Ȳ���ȣ�����false���޷�������
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


    //solve 1 ʵ��һ���㷨����ʹ�ö�������ݽṹ���ж��ַ����е�ÿ���ַ��Ƿ񶼲����
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

    //solve 2 ʵ��һ���㷨����ʹ�ö�������ݽṹ���ж��ַ����е�ÿ���ַ��Ƿ񶼲����
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
