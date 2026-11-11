import java.io.*;
import java.util.*;

class heapSort{
    int count;
    int[] heapArr;

    heapSort(){
        this.count = 0;
        this.heapArr = null;
    }

    // Use from prev projects
    int countData(Scanner inFile, PrintWriter log){
        log.println("Entering countData()");
        this.count = 0;
        while(inFile.hasNextInt()){
            inFile.nextInt();
            this.count++;
        }
        log.println("Exiting countData()");
        return this.count;
    }

    void buildHeap(Scanner inFile, int[] heapArr, PrintWriter log){
        log.println("Entering buildHeap()");

        while(inFile.hasNextInt()){
            int data = inFile.nextInt();
            heapArr[0]++;

            if(heapArr[0] <= count){
                heapArr[heapArr[0]] = data;
            }else{
                System.out.println("Error! Heap is full! This should not happen, program has bugs");
                System.exit(-1);
            }

            bubbleUp(heapArr, log);

            log.println("In buildHeap(), printing heapArr, after bubbleUp(" + data + ")");
            printHeap(heapArr, log);
        }

        log.println("Leaving buildHeap()");
    }

    void dumpHeap(int[] heapArr, PrintWriter out, PrintWriter log){
        log.println("Entering dumpHeap()");

        while(heapArr[0] > 0){
            out.println(heapArr[1]);
            heapArr[1] = heapArr[heapArr[0]];
            heapArr[0]--;

            bubbleDown(heapArr, log);

            log.println("In dumpHeap(), printing heapArr, after bubbleDown()");
            printHeap(heapArr, log);
        }

        log.println("Leaving dumpHeap()");
    }

    void bubbleUp(int[] heapArr, PrintWriter log){
        log.println("Entering bubbleUp()");
        int spot = heapArr[0];
        int father = spot/2;
        while(spot > 1 && father >= 1 && heapArr[spot] < heapArr[father]){
            mySwap(heapArr, spot, father);
            spot = father;
            father = spot/2;
            log.println("In bubbleUp(), printing heapArr one step up");
            printHeap(heapArr, log);
        }

        log.println("Leaving bubbleUp()");
    }

    void bubbleDown(int[] heapArr, PrintWriter log){
        log.println("Entering bubbleDown()");
        int spot = 1;

        int leftChild = spot*2;
        int rightChild = spot*2 + 1;
        int minChild = findMinChild(heapArr, leftChild, rightChild, log);
        while(minChild <= heapArr[0] && spot >= 1 && heapArr[minChild] < heapArr[spot]){
            mySwap(heapArr, minChild, spot);
            spot = minChild;
            log.println("In bubbleDown(), print heapArr down one step");
            printHeap(heapArr, log);

            leftChild = spot*2;
            rightChild = spot*2 + 1;
            minChild = findMinChild(heapArr, leftChild, rightChild, log);
        }

        log.println("Leaving bubbleDown()");
    }

    int findMinChild(int[] heapArr, int leftChild, int rightChild, PrintWriter log){
        log.println("Entering findMinChild()");

        int minIndex;
        if(leftChild > heapArr[0]){
            minIndex = leftChild;
        }else{
            if(rightChild > heapArr[0]){
                minIndex = leftChild;
            }else{
                if(heapArr[leftChild] <= heapArr[rightChild]){
                    minIndex = leftChild;
                }else{
                    minIndex = rightChild;
                }
            }
        }

        log.println("Leaving findMinChild(), returning minIndex: " + minIndex);
        return minIndex;
    }

    // On my own
    void mySwap(int[] heapArr, int i, int j){
        // i=spot, j=father
        int temp;
        temp = heapArr[i];
        heapArr[i] = heapArr[j];
        heapArr[j] = temp;
    }

    void printHeap(int[] heapArr, PrintWriter oFile){
        oFile.println("Index\theapArr[Index]");
        oFile.println("------------------------------");

        for(int i = 0; i <= heapArr[0]; i++){
            oFile.println(i + "\t" + heapArr[i]);
        }
    }
}

public class AlanP_Project7_Main{
    public static void main(String[] args){
        if(args.length != 3){
            System.out.println("Program needs 3 arguments.");
            System.exit(-1);
        }

        Scanner inFile = null;
        PrintWriter outFile = null;
        PrintWriter logFile = null;

        try{
            inFile = new Scanner(new BufferedReader(new FileReader(args[0])));
            System.out.println("inFile opened successfully.");
        }catch(IOException e){
            System.out.println("inFile cannot be opened.");
            System.exit(1);
        }
        try{
            outFile = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
            System.out.println("outFile opened successfully opened.");
        }catch(IOException e){
            System.out.println("outFile cannot be opened successfully.");
            System.exit(1);
        }
        try{
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(args[2])));
            System.out.println("logFile opened successfully.");
        }catch(IOException e){
            System.out.println("logFile cannot be opened.");
            System.exit(1);
        }

        heapSort sort = new heapSort();
        int count = sort.countData(inFile, logFile);

        sort.count = count;

        inFile.close();
        try{
            inFile = new Scanner(new BufferedReader(new FileReader(args[0])));
            System.out.println("inFile opened successfully.");
        }catch(IOException e){
            System.out.println("inFile cannot be opened.");
            System.exit(1);
        }

        sort.buildHeap(inFile, sort.heapArr, logFile);
        outFile.println("In main() printing heapArr after buildHeap");
        sort.printHeap(sort.heapArr, logFile);

        sort.dumpHeap(sort.heapArr, outFile, logFile);
        outFile.println("In main() printing heapArr after dumpHeap");
        sort.printHeap(sort.heapArr, outFile);

        inFile.close();
        outFile.close();
        logFile.close();
    }
}
