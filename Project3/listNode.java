import java.io.*; // For file I/O
import java.util.*; // For console I/O and other built-in funcs

public class listNode{
    int data;
    listNode next;

    public listNode(int data){
        this.data = data;
        this.next = null;
    }

    public void printNode(listNode node, PrintWriter outFile){
        if(node.next != null){
            outFile.print("(" + node.data + ", " + node.next.data + ") -> ");
        }else{
            outFile.println("(" + node.data + ", NULL) -> ");
        }
    }
}

public class AlanP_Project3_Main {
    
}
