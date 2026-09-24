import java.io.*; // For file I/O
import java.util.*; // For console I/O and other built-in funcs

class listNode{
    int data;
    listNode next;

    listNode(int data){
        this.data = data;
        this.next = null;
    }

    void printNode(listNode node, PrintWriter outFile){
        if(node.next != null){
            outFile.print("(" + node.data + ", " + node.next.data + ") -> ");
        }else{
            outFile.println("(" + node.data + ", NULL) -> ");
        }
    }
}

class LLStack{
    listNode top;
    LLStack(){
        top = new listNode(-999);
    }

    boolean isEmpty(){
        return top.next == null;
    }

    void push(listNode node){
        node.next = top.next;
        top.next = node;
    }

    listNode pop(PrintWriter outFile){
        if(isEmpty()){
            outFile.println("Stack is empty!");
            return null;
        }else{
            listNode tmp = top.next;
            top.next = tmp.next;
            tmp.next = null;
            return tmp;
        }
    }

    void buildStack(Scanner inFile, PrintWriter logFile){
        logFile.println("***Entering buildStack()***");
        while(inFile.hasNextInt()){
            int data = inFile.nextInt();
            logFile.println("***Input data: " + data + "***");
            listNode newNode = new listNode(data);
            push(newNode);
        }
        logFile.println("***Leaving buildStack()***");
    }

    void printStack(PrintWriter outFile3){
        outFile3.print("Top -> ");
        listNode walker = top;
        while(walker != null){
            walker.printNode(walker, outFile3);
            walker = walker.next;
        }
        outFile3.println(" NULL");
    }
}

public class AlanP_Project3_Main {
    
}
