package Project1A;

import java.io.*;
import java.util.*;

public class AlanP_Project1A_Main{
    public static void main(String[] args)throws IOException{
        if(args.length != 2){
            System.out.println("Program needs 2 arguments.");
            System.exit(1);
        }

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