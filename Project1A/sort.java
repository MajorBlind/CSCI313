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
    public int countData(Scanner inFile, PrintWriter logFile){
        logFile.println("Entering countData()");
        int count = 0;
        while(inFile.hasNext()){
            String data = inFile.next();
            count++;
        }
        logFile.println("Leaving countData - Data Count: " + count);
        return count;
    }

    //loadData - Read data from inFile and store in dataAry
    public void loadData(Scanner inFile, String[] dataAry, int count, PrintWriter logFile){
        logFile.println("Entering loadData()");
        int index = 0;
        while(inFile.hasNext() && index < count){
            String data = inFile.next();
            dataAry[index] = data;
            index++;
        }
        logFile.println("Leaving loadData()");
    }

    //print dataAry(dataAry, fileOut) - output each data in dataAry to fileOut, 0 -> -1
    //one data per text line
    public void printDataAry(String[] dataAry, PrintWriter fileOut, PrintWriter logFile){
        logFile.println("Entering printDataAry()");
        fileOut.println("**The content of Array**");
        fileOut.println("Index\tData\n==========");
        for(int i = 0; i < dataAry.length; i++){
            fileOut.println(i + "\t" + dataAry[i]);
        }
    }
}

public class AlanP_Project1A_Main{
    public static void main(String[] args)throws IOException{
        //Check args amount is correct
        if(args.length != 3){
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

        int count = sort.countData(inFile, logFile);
        sort sorter = new sort(count, inFile);
    }
}