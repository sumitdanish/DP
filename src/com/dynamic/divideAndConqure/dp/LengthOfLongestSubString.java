package com.dynamic.divideAndConqure.dp;

public class LengthOfLongestSubString {
    public static void main(String[] args) {
        char[] ch = "GEEKSFORGEEKS".toCharArray();
        int len = maxUniqueSubString(ch);
        System.out.println("len = " + len);
    }
    
    public static int maxUniqueSubString(char[] ch) {
        int[] v = new int[256];
        int count = 1;
        v[ch[0]] = 0;
        int pre = 0;
        int maxLen = 0;
        for (int i = 1; i < ch.length; i++) {
            pre = v[ch[i]];
            if (pre == -1 || i - count > pre) {
                count++;
            } else {
                if (maxLen < count) {
                    maxLen = count;
                }
                count = i - pre;
            }
            v[ch[i]] = i;
        }
        return maxLen;
    }
}
