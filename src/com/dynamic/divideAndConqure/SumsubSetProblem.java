package com.dynamic.divideAndConqure;

public class SumsubSetProblem {
    public static void main(String[] args) {
        int[] s = {1,2,3,4,5,6};
        isSumDp(s,9);
       /* boolean b = isSum(9,s,s.length);
        System.out.println("b = " + b);*/
    }

    public static boolean isSum(int sum,int[] s,int len){
        if(sum == 0 && len >= 0){
            return true;
        }
        if(sum != 0 && len < 0){
            return false;
        }
        if(s[len-1] > sum){
            return false;
        }
        return (isSum(sum-s[len-1],s,len-1)) || isSum(sum,s,len-1);
    }

    public static void isSumDp(int[] s,int sum){
        boolean[][] b = new boolean[sum+1][s.length];
        for(int i = 0 ;i<=sum;i++){
            for(int j =1;j<s.length-1;j++){
                if(i ==0 && j >= 0){
                    b[i][j] = true;
                } else if(i < s[j-1]){
                    b[i][j] = b[i][j-1];
                }else if(i > s[j-1]){
                    b[i][j] = b[i - s[j-1]][j-1] || b[i][j-1];
                }
            }
        }
        System.out.println("b = " + b[sum][s.length-1]);
    }
}
