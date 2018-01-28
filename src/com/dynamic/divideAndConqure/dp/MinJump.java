package com.dynamic.divideAndConqure.dp;

import org.omg.CORBA.INTERNAL;

public class MinJump {
    public static void main(String[] args) {
        int[] a = {1, 3, 6, 1, 0, 9};
        /*int m = minJump(a,0,a.length);
        System.out.println("m = " + m);*/
        minJumpDP(a,0,a.length);
    }
    public static int minJump(int[] a,int st,int end){
        if(st == end-1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(a[st] == 0){
            return Integer.MAX_VALUE;
        }
        for(int i = st + 1;i < end && i<= st + a[st];i++){
            int jump = minJump(a,i,end);
            if(jump != Integer.MAX_VALUE && 1 + jump < min){
                min = 1 + jump;
            }
        }
        return min;
    }

    public static void minJumpDP(int[] a,int st,int end){
        int[] jump = new int[a.length];

        for(int i =1;i<a.length;i++){
            jump[i] = Integer.MAX_VALUE;
            for(int j = 0;j<i+a[i] && j <= i;j++){
                if(jump[j] != Integer.MAX_VALUE && 1 + jump[j] < jump[i]){
                    jump[i] = 1+jump[j];
                }
            }
        }
        System.out.println("jump = " + jump[a.length-1]);
    }
}
