package com.dynamic.divideAndConqure.dp;

public class LCS {
    public static void main(String[] args) {
        maxLCSDP("AGGTAB", "GXTXAYB");
        //System.out.println("len = " + len);
    }

    public static int maxLenLCS(String s1, String s2) {
        if (s1.length() <= 0) {
            return 0;
        }
        if (s2.length() <= 0) {
            return 0;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            return 1 + maxLenLCS(s1.substring(1), s2.substring(1));
        }
        return max(maxLenLCS(s1, s2.substring(1)), maxLenLCS(s1.substring(1), s2));
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void maxLCSDP(String s1, String s2) {
        int[][] t = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i <= 0 || j <= 0) {
                    t[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        System.out.println("t = " + t[s1.length()][s2.length()]);
    }
}
