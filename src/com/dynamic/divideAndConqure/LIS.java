package com.dynamic.divideAndConqure;

public class LIS {
    static int x = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] lis = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        /*int c =  lis(lis,lis.length);
        System.out.print(x);*/
        lisDP(lis);
    }

    private static int lis(int[] num, int len) {
        if (len == 0) {
            return 1;
        }
        int res = 1;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            res = lis(num, i - 1);
            if (num[i - 1] < num[len - 1] && 1 + res > maxLen) {
                maxLen = 1 + res;
            }
        }
        if (x < maxLen) {
            x = maxLen;
        }
        return maxLen;
    }

    private static void lisDP(int[] num) {
        int[] lis = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            lis[i] = 1;
        }
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && 1 + lis[j] > lis[i]) {
                    lis[i] = 1 + lis[j];
                }
            }
        }
        System.out.println(lis[num.length - 1]);
    }
}
