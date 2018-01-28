package com.dynamic.divideAndConqure.dp;

public class MinimumInsertion {
    static int x = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] a = {4, 6, 5, 1};
        /*int x1 = minInsertion(a,a.length);
        System.out.println("x1 = " + x);*/
        minInsertionDP(a,a.length);
    }
    
    public static int minInsertion(int[] a,int len){
        if(len == 0){
            return 1;
        }
        int res = 1;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 1;i < len ; i++){
            res = minInsertion(a,i-1);
            if(a[len-1] > a[i-1] && 1 + res > maxLen){
                maxLen = 1 + res;
            }
        }
        if(maxLen  > x){
            x = maxLen;
        }
        return maxLen;
    }
    
    public static void minInsertionDP(int[] a,int len){
        int[] lis = new int[len+1];
        for(int i = 0; i < len ; i++){
            lis[i] = 1;
        }
        for(int i = 1 ;i < len;i++){
            for(int j = 0;j<i;j++){
                if(a[i] > a[j] && 1 + lis[j] > lis[i]){
                    lis[i] = 1 + lis[j];
                }
            }
        }
        int ma = 0;
        for(int i = 0 ;i < len ; i++){
            if(ma < lis[i]){
                ma = lis[i];
            }
        }
        System.out.println("ma = " + (len - ma));
    }
}
