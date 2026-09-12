import java.io.*;
import java.util.*;

class Sort{
    private int count;
    private String[] dataAry;

    //Constructor
    Sort(int count, String[] dataAry){
        this.count = count;
        this.dataAry = dataAry;
    }

    //int countData - read/return count of data in inFile
    public static int countData(Scanner inFile, PrintWriter logFile){
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
    public static void loadData(Scanner inFile, String[] dataAry, int count, PrintWriter logFile){
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
    public static void printDataAry(String[] dataAry, PrintWriter fileOut, PrintWriter logFile){
        logFile.println("Entering printDataAry()");
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

        Sort sortObject = new Sort(0, null);
        int count = sortObject.countData(inFile, logFile);
        
        logFile.println("In main() count = " + count);
        String[] dataAry = new String[count];
        inFile.close();

        inFile = new Scanner(new FileReader(args[0]));

        sortObject.loadData(inFile, dataAry, count, logFile);
        outFile.println("**The content of Array**");
        outFile.println("Index\tData");
        outFile.println("==========");
        sortObject.printDataAry(dataAry, outFile, logFile);

        inFile.close();
        outFile.close();
        logFile.close();
    }
}