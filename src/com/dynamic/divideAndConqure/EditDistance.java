package com.dynamic.divideAndConqure;

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        editDistanceDP(str1,str2);
        /*int c = editDitance(str1,str2);
        System.out.println("c = " + c);*/
    }

    private static int editDitance(String str1, String str2) {
        /*
        * this is the case when first string is empty
        * */
        if (str1.length() <= 0) {
            return str2.length();
        }
        if(str2.length() <= 0){
            return str1.length();
        }
        if (str1.charAt(0) == str2.charAt(0)) {
            return editDitance(str1.substring(1), str2.substring(1));
        }
        return 1 + min(editDitance(str1, str2.substring(1)), min(editDitance
                (str1.substring(1), str2.substring(1)), editDitance
                (str1.substring(1), str2)));
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    private static void editDistanceDP(String str1,String str2){
        int[][] e = new int[str1.length()][str2.length()];
        for(int i = 0; i < str1.length() ; i++){
            for(int j = 0; j< str2.length() ; j++){
                if(i == 0){
                    e[i][j] = j;
                }else if(j == 0){
                    e[i][j] = i;
                }
                else if(str1.charAt(i) == str2.charAt(j)){
                    e[i][j] = e[i-1][j-1];
                }else{
                    e[i][j] = 1 + min(e[i][j-1],min(e[i-1][j-1],e[i-1][j]));
                }
            }
        }
        System.out.println(e[str1.length()-1][str2.length()-1]);
    }
}
