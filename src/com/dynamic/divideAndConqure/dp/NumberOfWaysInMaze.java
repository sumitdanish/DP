package com.dynamic.divideAndConqure.dp;
//https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
public class NumberOfWaysInMaze {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0, 0}, {0, -1, 0, 0}, {-1, 0, 0, 0}, {0, 0, 0, 0}};
        /*int m = ways(mat,4,4);
        System.out.println("m = " + m);*/
        waysDP(mat,4,4);
    }
    
    private static int ways(int[][] mat, int row, int col) {
        if(row == 0 || col == 0){
            return 0;
        }
        if (mat[row - 1][col - 1] == 0) {
            return 1 + ways(mat,row-1,col-1);
        }
        if (mat[row - 1][col] == -1) {
            return ways(mat,row-1,col);
        }
        if(mat[row][col-1]==-1){
            return ways(mat,row,col-1);
        }
        return ways(mat, row - 1, col) + ways(mat, row, col - 1);
    }
    
    private static void waysDP(int[][] mat,int row,int col){
        int[][] val = new int[row+1][col+1];
        for(int i = 0; i < row; i++){
            if(mat[i][0] == 0){
                val[i][0] = 1;
            }else{
                break;
            }
        }
        for(int i = 0; i < col ; i++){
            if(mat[0][i] == 0){
                val[0][i] = 1;
            }else{
                break;
            }
        }
        for(int i = 1 ; i< row ; i++){
            for(int j = 1; j < col ; j++){
                if(mat[i -1][j] == -1){
                    val[i][j] = val[i-1][j];
                }else if(mat[i][j-1] == -1){
                    val[i][j] = val[i][j-1];
                }else if(mat[i-1][j-1] == 0){
                    val[i][j] = 1 + val[i-1][j-1];
                }else{
                    val[i][j] = val[i-1][j]+val[i][j-1];
                }
            }
        }
        System.out.println("val[row-1][col-1] = " + val[row-1][col-1]);
    }
}
