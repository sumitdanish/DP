package com.dynamic.divideAndConqure;

public class MaximumSumIncressingSubSequence {
    public static void main(String[] args) {
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        sum(arr);
    }
    public static void sum(int[] num){
       int[] s = new int[num.length];
       for(int i =0; i < num.length ; i++){
           s[i] = num[i];
       }
       int max = Integer.MIN_VALUE;
       for(int i =1;i < num.length;i++){
           for(int j = 0; j <i;j++){
               if(num[i] > num[j] && s[i] < s[j]+num[i]){
                   s[i] = s[j]+num[i];
               }
           }
       }
       for(int i = 0; i < num.length ; i++){
           if(max < s[i]){
               max = s[i];
           }
       }
        System.out.println("max = " + max);
    }
}
