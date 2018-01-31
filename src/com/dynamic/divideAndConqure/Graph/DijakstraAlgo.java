package com.dynamic.divideAndConqure.Graph;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DijakstraAlgo {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileInputStream(new File("dija.txt")));
        int v = sc.nextInt();
        int e = sc.nextInt();
        GraphMattrix g = new GraphMattrix(sc,v,e);
        g.makeGraph();
        g.dijakstraMindistance();
        g.print();
    }


}

class GraphMattrix{
    private int[][] g;
    private Scanner sc;
    private int e;
    private int v;
    private int[] visited;
    private int[] dist;
    public GraphMattrix(Scanner sc,int v,int e){
       this.sc = sc;
       this.v = v;
       this.e = e;
       this.visited = new int[v];
       this.dist = new int[this.v];
    }

    public void makeGraph(){
        System.out.println("v = " + v);
        this.g = new int[this.v][this.v];
        for(int i = 0 ; i < this.v ; i++){
            this.visited[i] = -1;
        }
        for(int i = 0 ; i < this.v ; i++){
            this.dist[i] = Integer.MAX_VALUE;
        }
        while(sc.hasNext()){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            addEadge(src,dest,weight);
        }
    }

    public void addEadge(int src,int dest,int w){
        g[src][dest] = w;
        g[dest][src] = w;
    }

    public int minIndex(int[] dist){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < this.v;i++){
            if(dist[i] <= min && this.visited[i] == -1){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void dijakstraMindistance(){
        this.dist[0] = 0;
        for(int i = 0; i < this.v ; i++){
            int u = minIndex(dist);
            visited[u] = 1;
            for(int x = 0; x < this.v ;x++){
                if(g[u][x] != 0 && visited[x] == 0 && dist[u] != Integer.MAX_VALUE && (dist[x] > dist[u]+g[u][x])){
                    dist[x] = dist[u]+g[u][x];
                }
            }
        }
    }

    public void print(){
        for(int i = 0; i < this.v ; i++){
            System.out.println("vertex = " + i +" , dist = "+dist[i]);
        }
    }
}