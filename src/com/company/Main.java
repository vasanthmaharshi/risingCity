package com.company;

import com.company.project.*;
import com.company.project.RBTHelper;

import java.io.*;
import  java.util.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            Project group_1 = new Project(2000);
            FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Git Projects\\RealEstate\\src\\com\\company\\input.txt");
            Scanner sc = new Scanner(fis);
            PrintStream fileOut = new PrintStream("C:\\Users\\Admin\\Desktop\\Git Projects\\RealEstate\\src\\com\\company\\output.txt");
            System.setOut(fileOut);
            int globalTime = 0;
            int workDone = 0;
            HeapNode presentConstruction = null;
            int commandTime = 0;
            String input = "";
            String command = "";

            while(sc.hasNextLine() || group_1.getRoot()!=null){
                if(workDone==0 || presentConstruction==null) {
                    presentConstruction = group_1.heapExtract();
                }
                if(presentConstruction!=null){
                    presentConstruction.setExecutedTime(presentConstruction.getExecutedTime() + 1);
                    workDone++;
                }

                if(sc.hasNextLine() && commandTime == 0){
                    input = sc.nextLine();
                    commandTime = Integer.parseInt(input.substring(0, input.indexOf(":")));
                    command = input.substring(input.indexOf(" ")+1,input.indexOf("("));

                }
                if (commandTime==globalTime){
                    if(command.equals("Insert")){
                        int buildingNum = Integer.parseInt(input.substring(input.indexOf('(')+1, input.indexOf(',')));
                        int totalTime = Integer.parseInt(input.substring(input.indexOf(',')+1, input.length()-1));
                        group_1.insert(buildingNum, 0, totalTime);
                    }else if(command.equals("PrintBuilding")){
                        String[] buildings = input.substring(input.indexOf('(')+1, input.length()-1).split(",");
                        if(buildings.length==1){
                            int buildingNum = Integer.parseInt(buildings[0]);
                            group_1.printBuilding(buildingNum);

                        }else {
                            int building1 = Integer.parseInt(buildings[0]);
                            int building2 = Integer.parseInt(buildings[1]);
                            group_1.printBuildings(building1, building2);
                        }
                    }
                    commandTime = 0;
                    /*if(sc.hasNextLine()){
                        input = sc.nextLine();
                        commandTime = Integer.parseInt(input.substring(0, input.indexOf(":")));
                        command = input.substring(input.indexOf(" ")+1,input.indexOf("("));
                        //System.out.println(command);
                    }*/
                }

                if (presentConstruction!=null && presentConstruction.getExecutedTime() == presentConstruction.getTotalTime()) {
                    workDone = 0;
                    System.out.printf("(%d,%d)\n", presentConstruction.getBuildingNum(), globalTime);
                    group_1.deleteNode(presentConstruction.getBuildingNum());
                    presentConstruction = null;
                }
                if (workDone == 5) {
                    workDone = 0;
                    group_1.heapInsert(presentConstruction);
                    presentConstruction = null;
                }
                globalTime++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}