package com.dynamic.divideAndConqure.dp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
/*
* https://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
*
* */
public class LISInChainOfPair {
    static int x = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        List<Pair> pairs = new ArrayList<>();
        Scanner sc = new Scanner(new FileInputStream(new File("c.txt")));
        int i = 0;
        while(sc.hasNext()){
            String[] s = sc.next().split(",");
            Pair p = new Pair(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            pairs.add(p);
        }
        Collections.sort(pairs,new PairSort());
        int y = lisInChainOfPairs(pairs.toArray(new Pair[pairs.size()]),pairs.size
                ());
        System.out.println(x);
    }

    private static int lisInChainOfPairs(Pair[] pairs,int len){
        if(len <= 0){
            return 1;
        }
        int res = 1;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 1 ;i < len ; i++){
            res = lisInChainOfPairs(pairs,i-1);
            if(pairs[i-1].getY() < pairs[len-1].getY() && maxLen < 1 + res){
                maxLen = 1 + res;
            }
        }
        if(x < maxLen){
            x = maxLen;
        }
        return maxLen;
    }
}
class PairSort implements Comparator<Pair>{

    @Override
    public int compare(Pair o1, Pair o2) {
        if(o1.getX() > o2.getX()){
            return 1;
        }
        return -1;
    }
}
class Pair{
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
