package com.dynamic.divideAndConqure.dp;

public class MinCutRod {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int min = minCut(price,price.length);
        System.out.println("min = " + min);
    }
    public static int minCut(int[] price,int len){
        if(len == 0){
            return 0;
        }
        int min = Integer.MIN_VALUE;
        for(int i = 0 ; i< len ; i++){
            min = max(min,price[i]+minCut(price,len-i-1));
        }
        return min;
    }

    public static void minCutDP(int[] price){
        int[] pr = new int[price.length+1];
        for(int i = 0; i < price.length ; i++){

        }
    }

    private static int max(int a,int b){
        return a > b ? a : b;
    }
}
