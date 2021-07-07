package com.company.project;

import com.company.HeapNode;
import com.company.RBTNode;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Project {

    private HeapNode[] heap;
    private RBTHelper rbthelper;
    private heapHelper heaphelper;
    public Project(int size){
        heap = new HeapNode[size];
        rbthelper = new RBTHelper();
        heaphelper = new heapHelper(size);
    }

    public HeapNode[] getHeap() {
        return heap;
    }

    public void setHeap(HeapNode[] heap) {
        this.heap = heap;
    }

    public void insert(int buildingNum, int executedTime, int totalTime){
        HeapNode newHeapNode = new HeapNode(buildingNum, executedTime, totalTime);
        heapInsert(newHeapNode);
        RBTNode newRBTNode = new RBTNode(buildingNum, newHeapNode);
        newRBTNode.setHeapNode(newHeapNode);
        RBTInsert(newRBTNode);
    }

    public void heapInsert(HeapNode heapNode){
        heaphelper.heapInsert(heapNode);
    }

    public void RBTInsert(RBTNode rbtNode){
        rbthelper.RBTInsert(rbtNode);
    }

    public void deleteNode(int buildingNum){
        rbthelper.deleteNode(buildingNum);
    }

    public HeapNode heapExtract(){
        HeapNode x = heaphelper.heapExtract();
        heaphelper.heapDelete();
        return x;
    }

    public void printBuilding(int buildingNum){
        rbthelper.printBuilding(buildingNum);
    }

    public void printBuildings(int building1, int building2){
        rbthelper.printBuildings(building1, building2);
    }


    public void printHeap(){
        heaphelper.printHeap();
    }

    public void printRBT(){
        rbthelper.printRBT();
    }

    public int getSize(){
        return heaphelper.getSize();
    }

    public RBTNode getRoot(){
        return rbthelper.getRoot();
    }

}
