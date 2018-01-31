package com.dynamic.divideAndConqure.Graph;

import java.util.PriorityQueue;

public class DijakstraAlgo {
    public static void main(String[] args) {
        PriorityQueue p = new PriorityQueue();
    }
}

class DNode{
    private DNode next;
    private int data;

    public DNode(){

    }
    public DNode(int data){
        this.data = data;
    }
    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
