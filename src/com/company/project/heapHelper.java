package com.company.project;


import com.company.HeapNode;

public class heapHelper {
    private HeapNode[] Heap;
    private int size = 0;

    public HeapNode[] getHeap() {
        return Heap;
    }

    public void setHeap(HeapNode[] heap) {
        Heap = heap;
    }

    public int getSize() {
        return size;
    }

    public heapHelper(int size){
        Heap = new HeapNode[2000];
    }

    public void heapInsert(HeapNode newNode){
        Heap[size] = newNode;
        heapifyUp(size);
        size++;
    }

    public void heapDelete(){
        if(size==0){
            return;
        }
        Heap[0] = Heap[size-1];
        size--;
        heapifyDown(0);
    }

    public HeapNode heapExtract(){
        HeapNode x = Heap[0];
        return x;
    }

    public void heapifyUp(int curr){
        int parent = (curr-1)/2;
        if(curr==0 || Heap[curr].getExecutedTime()>Heap[parent].getExecutedTime()){
            return;
        }
        if(Heap[curr].getExecutedTime()<Heap[parent].getExecutedTime()){
            swapNodes(curr, parent);
            heapifyUp(parent);
        }else if(Heap[curr].getBuildingNum()<Heap[parent].getBuildingNum()){
            swapNodes(curr, parent);
            heapifyUp(parent);
        }
    }

    public void heapifyDown(int curr){
        if(curr==size){
            return;
        }
        int minNode;
        int leftChild = 2*curr+1;
        int rightChild = 2*curr+2;
        if(leftChild>size-1){
            return;
        }
        if(rightChild>size-1){
            minNode = leftChild;
        }else if(Heap[leftChild].getExecutedTime()<Heap[rightChild].getExecutedTime()){
            minNode = leftChild;
        }else if(Heap[leftChild].getExecutedTime()>Heap[rightChild].getExecutedTime()){
            minNode = rightChild;
        }else {
            if(Heap[leftChild].getBuildingNum()<Heap[rightChild].getBuildingNum()){
                minNode = leftChild;
            }else {
                minNode = rightChild;
            }
        }
        if(Heap[curr].getExecutedTime()>Heap[minNode].getExecutedTime()){
            swapNodes(curr, minNode);
            heapifyDown(minNode);
        }else if(Heap[curr].getExecutedTime()==Heap[minNode].getExecutedTime()){
            if(Heap[curr].getBuildingNum()>Heap[minNode].getBuildingNum()){
                swapNodes(curr, minNode);
                heapifyDown(minNode);
            }
        }

    }

    public void swapNodes(int a, int b){
        HeapNode temp = Heap[a];
        Heap[a] = Heap[b];
        Heap[b] = temp;
    }
    public void printHeap(){
        for(int j=0;j<size;j++){
            System.out.print(Heap[j].getBuildingNum()+" ");
        }
        System.out.println();
    }
}
