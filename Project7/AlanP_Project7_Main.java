import java.io.*;
import java.util.*;

class heapSort{
    int count;
    int[] heapArr;

    heapSort(){
        this.count = 0;
        heapArr = null;
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
        int data = inFile.nextInt();
        while(inFile.hasNextInt()){
            heapArr[0]++;

            if(heapArr[0] <= count){
                heapArr[heapArr[0]] = data;
            }else{
                System.out.println("Error! Heap is full! This should not happen, program has bugs");
                System.exit(-1);
            }

            bubbleUp(heapArr);

            log.println("In buildUp(), printing heapArr, after bubbleUp(data)");
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
        while(spot > 1 && father >= 1 && heapArr[spot] > heapArr[father]){
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
    }

    int findMinChild(int[] heapArr, int leftChild, int rightChild, PrintWriter log){
        log.println("Entering findMinChild()");

        int minIndex;
        if(leftChild > heapArr[0]){
            minIndex = leftChild;
        }else{
            if(rightChild > heapArr[0]){
                minIndex = rightChild;
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
    public static void main(String[] args){}
}
