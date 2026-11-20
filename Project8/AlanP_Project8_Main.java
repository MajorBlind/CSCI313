import java.io.*;
import java.util.*;

class bucketSort{
    int minInt;
    int maxInt;
    int offSet;

    int arrSize = maxInt + offSet + 1;
    int[] bucketArr;

    public bucketSort(){
        minInt = 0;
        maxInt = 0;
        offSet = 0;
        arrSize = 0;
        bucketArr = null;
    }

    public void findMinMax(Scanner in, PrintWriter log){
        log.println("Entering findMinMax()");

        if(!in.hasNextInt()){
            log.println("File has no integers");
            System.exit(-1);
        }

        int data = in.nextInt();
        minInt = data;
        maxInt = data;

        while(in.hasNextInt()){
            data = in.nextInt();
            if(data > maxInt){
                maxInt = data;
            }
            if(data < minInt){
                minInt = data;
            }
        }

        log.println("Leaving findMinMax. minInt = " + minInt + ", maxInt = " + maxInt);
    }

    public void fillBuckets(Scanner in, PrintWriter log){
        log.println("Entering fillBuckets()");

        while(in.hasNextInt()){
            int bin = in.nextInt();
            int binAdd = bin + offSet;
            log.println("In fillBuckets, offSet = " + offSet + ", bin = " + bin + ", binAdd = " + binAdd + "arrSize = " + arrSize);
            if(binAdd > arrSize){
                log.println("Error, binAdd greater than arrSize. binAdd = " + binAdd + ", arrSize = " + arrSize);
                System.exit(-1);
            }

            bucketArr[binAdd]++;

            printBuckets(logFile);
        }

        log.println("Leaving fillBuckets()");
    }

    public void printBuckets(){}

    public void printSortedData(){}
}

public class AlanP_Project8_Main{
    public static void main(String[] args){
        // Filled in after class completed
    }
}