package com.dynamic.divideAndConqure.dp;

public class MinHeap {
    public static void main(String[] args) {
        int[] a = {10,4,9,-10,2,5,1};
        MinHeapImpl m = new MinHeapImpl(a.length);
        for(int s : a){
            m.insert(s);
        }
        for(int i = 0 ;i < a.length ; i++) {
            System.out.println("m.remove() = " + m.remove());
        }
    }
}

class MinHeapImpl{
    private int[] data;
    private int size;
    public MinHeapImpl(int size){
        data = new int[2*size+1];
        data[0] = 0;
    }

    public boolean isLeaf(int index){
        return 2*index > this.data[0];
    }

    public void insert(int val){
        ++this.data[0];
        this.data[this.data[0]] = val;
        bubbleUp(this.data[0]);

    }
    public void sinkDown(int index){
        if(isLeaf(index)){
            return;
        }
        int l = 2 * index;
        int r = 2* index + 1;
        int minIndex = l;
        if(r > this.data[0] && l < r){
            minIndex = l;
        }else{
            minIndex = this.data[l] < this.data[r] ? l : r;
        }
        if(this.data[index] < this.data[minIndex]){
            return;
        }
        int temp = this.data[index];
        this.data[index] = this.data[minIndex];
        this.data[minIndex] = temp;
        sinkDown(minIndex);
    }

    public void bubbleUp(int index){
        int p = index/2;
        if(index == 1 || this.data[p] < this.data[index]){
            return;
        }
        int temp = this.data[p];
        this.data[p] = this.data[index];
        this.data[index] = temp;
        bubbleUp(p);
    }
    public int remove(){
        int min = this.data[1];
        int l = this.data[this.data[0]--];
        this.data[1] = l;
        sinkDown(1);
        return min;
    }
}
