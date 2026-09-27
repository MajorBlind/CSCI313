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
            outFile.print("(" + node.data + ", NULL) -> ");
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
        outFile3.println("NULL");
    }
}

class LLQueue{
    listNode head;
    listNode tail;

    LLQueue(){
        head = new listNode(-999);
        tail = head;
    }

    void insertQ(listNode newNode){
        tail.next = newNode;
        tail = newNode;
    }

    boolean isEmpty(){
        return head.next == null;
    }

    void buildQueue(LLStack S, PrintWriter outFile2, PrintWriter logFile){
        logFile.println("***Entering buildQueue()!");
        while(!S.isEmpty()){
            listNode newNode = S.pop(outFile2);
            logFile.println("***After pop stack, newNode's data is: " + newNode.data);
            outFile2.println("***After pop stack, newNode's data is: " + newNode.data);
            insertQ(newNode);
        }
        logFile.println("***Leaving buildQueue()!");
    }

    void printQueue(PrintWriter outFile2){
        listNode walker = head;
        outFile2.print("Head -> ");
        while(walker != null){
            walker.printNode(walker, outFile2);
            walker = walker.next;
        }
        outFile2.println("Tail");
    }
}

public class AlanP_Project3_Main {
    public static void main(String[] args)throws IOException{
        if(args.length != 4){
            System.out.println("Program needs 4 arguments.");
            System.exit(1);
        }

        Scanner inFile = null;
        PrintWriter outFile1 = null;
        PrintWriter outFile2 = null;
        PrintWriter logFile = null;

        try{
            inFile = new Scanner(new FileReader(args[0]));
            System.out.println("inFile opened successfully.");
        }catch(IOException e){
            System.out.println("inFile cannot be opened.");
            System.exit(1);
        }
        try{
            outFile1 = new PrintWriter(args[1]);
            System.out.println("outFile1 opened successfully.");
        }catch(IOException e){
            System.out.println("outFile1 cannot be opened.");
            System.exit(1);
        }
        try{
            outFile2 = new PrintWriter(args[2]);
            System.out.println("outFile2 opened successfully.");
        }catch(IOException e){
            System.out.println("outFile2 cannot be opened.");
            System.exit(1);
        }
        try{
            logFile = new PrintWriter(args[3]);
            System.out.println("logFile opened successfully.");
        }catch(IOException e){
            System.out.println("logFile cannot be opened.");
            System.exit(1);
        }

        LLStack S = new LLStack();

        logFile.println("***Calling buildStack()");
        S.buildStack(inFile, logFile);
        outFile1.println("Printing the stack***");
        S.printStack(outFile1);

        LLQueue Q = new LLQueue();

        logFile.println("***Calling buildQueue()");
        Q.buildQueue(S, outFile2, logFile);
        outFile2.println("***Printing the Queue");
        Q.printQueue(outFile2);

        inFile.close();
        outFile1.close();
        outFile2.close();
        logFile.close();
    }
}
