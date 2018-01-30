package com.dynamic.divideAndConqure.Graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
public class DisjointSet {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner( new FileInputStream( new File( "dis.txt" )
    ) );
    int v = sc.nextInt();
    int e = sc.nextInt();
    GraphD g = new GraphD( v ,e);
    g.makeGraph( sc );
    System.out.println(g.isCycle());
  }


}

class GraphD {
  private int v;
  private int e;
  private GraphD[] g = null;
  public Eadge[] eadge;
  public GraphD(){

  }
  public GraphD(int v,int e) {
    this.v = v;
    this.e = e;
    eadge = new Eadge[e];
    for(int i = 0; i < e; i ++){
      eadge[i] = new Eadge();
    }
  }

  public void makeGraph(Scanner sc) {
    int i = 0;
    while (sc.hasNext() && i < this.e) {
      Eadge e = createGraph( sc.nextInt(), sc.nextInt() );
      eadge[i] = e;
      i++;
    }
  }

  public Eadge createGraph(int src, int dest) {
    Eadge e = new Eadge();
    e.src = src;
    e.dest = dest;
    return e;
  }

  public GraphD[] getGraph(){
    return this.g;
  }

  public boolean isCycle(){
    Subset[] subSet = new Subset[this.v];
    for(int i = 0; i < this.v ; i++){
      subSet[i] = new Subset();
      subSet[i].parent = i;
      subSet[i].rank = 0;
    }
    for(int i = 0; i < this.e ; i++){
     int x1 =  find( eadge[i].src,subSet );
     int x2 = find(eadge[i].dest,subSet);
     //System.out.println(x1 +" : "+x2);
     if(x1 == x2){
       return true;
     }
     union( eadge[i].src,eadge[i].dest,subSet );
    }
    return false;
  }
  public int find(int i, Subset[] set) {
    if (!(i >= 0 && i < set.length)) {
      return Integer.MIN_VALUE;
    }
    if (set[i].parent == i) {
      return i;
    }
    return find( set[i].parent, set );
  }

  public void union(int root1, int root2, Subset[] set) {
    int findNode1 = find( root1,set );
    int findNode2 = find( root2,set );
    int rank1 = set[findNode1].rank;
    int rank2 = set[findNode2].rank;
    if (rank1 < rank2) {
      set[findNode1].parent = findNode2;
    } else if (rank1 > rank2) {
      set[findNode2].parent = findNode1;
    } else {
      set[findNode1].parent = findNode2;
      set[findNode2].rank += 1;
    }
  }
}

class Eadge {
  public int src;
  public int dest;
}

class Subset {
  public int rank;
  public int parent;
}
