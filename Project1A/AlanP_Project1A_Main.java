package Project1A;

import java.io.*;
import java.util.*;

public class sort{
    private int count;
    private String[] dataAry;

    //Constructor
    sort(int count, String[] dataAry){
        this.count = count;
        this.dataAry = dataAry;
    }
    //int countData - read/return count of data in inFile

    //loadData - Read data from inFile and store in dataAry

    //print dataAry(dataAry, fileOut) - output each data in dataAry to fileOut, 0 -> -1
    //one data per text line
}

public class AlanP_Project1A_Main{
    public static void main(String[] args)throws IOException{
        //Check args amount is correct
        if(args.length != 2){
            System.out.println("Program needs 2 arguments.");
            System.exit(1);
        }

        //Init file reader/writers and check to see if they open
        Scanner inFile = null;
        PrintWriter outFile = null;
        PrintWriter logFile = null;

        try{
            inFile = new Scanner(new FileReader(args[0]));
            System.out.println("inFile opened successfully.");
        }catch(IOException e){
            System.out.println("inFile cannot be opened.");
            System.exit(1);
        }

        try{
            outFile = new PrintWriter(args[1]);
            System.out.println("outFile opened successfully.");
        }catch(IOException e){
            System.out.println("outFile cannot be opened.");
            System.exit(1);
        }

        try{
            logFile = new PrintWriter(args[2]);
            System.out.println("logFile opened successfully.");
        }catch(IOException e){
            System.out.println("logFile cannot be opened.");
            System.exit(1);
        }
    }
}