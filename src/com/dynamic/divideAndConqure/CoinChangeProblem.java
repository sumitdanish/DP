package com.dynamic.divideAndConqure;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int[] num = {2, 5, 3, 6};
        int coin = 10;
        coinChangeInDP(coin, num);

    }

    public static int coinChange(int coin, int[] num, int len) {
        if (coin == 0) {
            return 1;
        }
        if (len <= 0 || coin < 0) {
            return 0;
        }
        return coinChange(coin - num[len - 1], num, len)/*We can take same
        coin many number of times thats why we are not decresing value of len */ + coinChange(coin, num, len - 1);
    }

    public static void coinChangeInDP(int coin, int[] num) {
        int[][] val = new int[coin + 1][num.length + 1];
        int x = 0;
        int y = 0;
        for (int i = 1; i <= coin; i++) {
            for (int j = 0; j < num.length; j++) {
                if (j == 0 && i >= num[j]) {
                    val[i][j] = 1;
                } else if (i - num[j] >= 0 && j - 1 >= 0) {
                    val[i][j] = val[i - num[j]][j] + val[i][j - 1];
                }
            }
        }
        System.out.println("val[coin][num.length] = " + val[coin][num
                .length]);
    }


}
