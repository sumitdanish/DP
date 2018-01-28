package com.dynamic.divideAndConqure.dp;

public class PowFunction {
    public static void main(String[] args) {
        System.out.println("args = " + pow(2, 0));
    }

    private static int pow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int temp = pow(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        }
        return x * temp * temp;
    }
}
