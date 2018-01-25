package com.dynamic.divideAndConqure;

public class MinCostPathInMattrix {
    public static void main(String[] args) {
        int[][] cost = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        //int co = minCost(cost,2,2);
        //System.out.println("co = " + co);
        minCostInDp(cost, 3, 3);
    }

    public static int minCost(int[][] cost, int row, int col) {
        if (row == 0 && col == 0) {
            return cost[row][col];
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        return cost[row][col] + min(cost[row][col - 1], min(cost[row - 1][col - 1], cost[row - 1][col - 1]));
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void minCostInDp(int[][] cost, int row, int col) {
        int[][] c = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i - 1 == 0 && j - 1 == 0) {
                    c[i][j] = cost[i - 1][j - 1];
                } else if (i - 1 == 0 || j - 1 == 0) {
                    c[i][j] = 0;
                } else {
                    c[i][j] = cost[i - 1][j - 1] + min(c[i][j - 1], min(c[i - 1][j - 1], c[i - 1][j]));
                }
            }
        }
        System.out.println("c = " + c[row][col]);
    }
}
