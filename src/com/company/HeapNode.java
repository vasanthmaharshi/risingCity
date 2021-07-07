package com.company;

public class HeapNode {
    private final int buildingNum;
    private int executedTime;
    private int totalTime;
    public HeapNode(int buildingNum, int executedTime,int totalTime){
        this.buildingNum = buildingNum;
        this.executedTime = executedTime;
        this.totalTime = totalTime;
    }
    public int getExecutedTime() {
        return executedTime;
    }

    public int getBuildingNum() {
        return buildingNum;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void setExecutedTime(int executedTime) {
        this.executedTime = executedTime;
    }

}
