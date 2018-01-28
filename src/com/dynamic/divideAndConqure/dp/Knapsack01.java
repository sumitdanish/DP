package com.dynamic.divideAndConqure.dp;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] price = {60,100,120};
        int[] w = {10,20,30};
        int weight = 50;
        minPriceDP(price,w,weight);
       /* int val = maxWeight(w,price,weight,w.length);
        System.out.println("val = " + val);*/
    }
    public static int maxWeight(int[] w,int[] price,int weight,int len){
        if(len == 0 || weight == 0){
            return 0;
        }
        if(w[len-1] > weight){
            return maxWeight(w,price,weight,len-1);
        }
        return max((price[len-1] + maxWeight(w,price,weight - w[len-1],
                len-1)),
                maxWeight(w,price,weight,len-1));
    }
    public static int max(int a,int b){
        return a > b ? a : b;
    }

    public static void minPriceDP(int[] price,int[] w,int weight){
        int[][] pr = new int[weight+1][price.length];
        for(int w1 = 0;w1<=weight;w1++){
            for(int j =0; j < price.length;j++){
                if(w1 == 0 || j == 0){
                    pr[w1][j] = 0;
                }else if(w1 >= w[j]){
                    pr[w1][j] = max(price[j]+pr[w1 - w[j]][j-1],pr[w1][j-1]);
                }else{
                    pr[w1][j] = pr[w1][j-1];
                }
            }
        }
        System.out.println("pr = " + pr[weight][price.length-1]);
    }

}
