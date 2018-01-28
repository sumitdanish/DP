package com.dynamic.divideAndConqure.dp;

public class MaxNumberOfChocolates {
    public static void main(String[] args) {
        int a[] = {2, 7, 6, 1, 4, 5};
        maxChocolate(a,1);
    }
    
    private static void maxChocolate(int[] a,int k){
        int maxSoFar = a[0];
        int max = 0;
        int st = 0;
        int end = 0;
        boolean flag = true;
        for(int i = 1; i< a.length ; i++){
            maxSoFar += a[i];
            if(flag){
                st = i;
            }
            if(maxSoFar < 0){
                maxSoFar = 0;
                flag = true;
            } else if(max < maxSoFar){
                max = maxSoFar;
                end = i;
                flag = false;
                
            }
        }
    
        System.out.println("max = " + max +" start : "+st+" end : "+end);
    }
}
