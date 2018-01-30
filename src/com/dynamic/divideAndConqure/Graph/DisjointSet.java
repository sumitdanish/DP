package com.dynamic.divideAndConqure.Graph;
//https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
public class DisjointSet {
    public static void main(String[] args) {

    }
    public int find(int i,Subset[] set){
        if(!(i >= 0 && i < set.length)){
            return Integer.MIN_VALUE;
        }
        if(set[i].parent == i){
            return i;
        }
        return find(set[i].parent,set);
    }

    public void union(int root1,int root2,Subset[] set){
        if(find(root1,set) == find(root2,set)){
            return;
        }
        int rank1 = set[root1].rank;
        int rank2 = set[root2].rank;
        if(rank1 < rank2){
            set[root1].parent = root2;
        }else if(rank1 > rank2){
            set[root2].parent = root1;
        }else{
            set[root1].parent = root2;
            set[root2].rank += 1;
        }
    }
    public void createGraph(int v,int e){
        GraphD g = new GraphD();
        for(int i = 0; i < v ; i++){
            Eadge eadge = new Eadge();
            
        }
    }
}
class GraphD{
    public Eadge eadge;
}
class Eadge{
    public int src;
    public int dest;
}
class Subset{
    public int rank;
    public int parent;
}
