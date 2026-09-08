import java.io.*;
import java.util.*;

class Person{
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    void printPerson(PrintWriter oFile)throws IOException{
        String describe = name + " is " + age + " years old.";
        oFile.println(describe);
    }
} //End class Person

class AlanP_Project0A_Main{
    public static void main(String[] args)throws IOException{
        if(args.length != 2){
            System.out.println("Program needs 2 arguments.");
            System.exit(1);
        }
        
        Scanner inFile = null;
        PrintWriter outFile = null;
        
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
            System.out.println("outFile could not be opened.");
            System.exit(1);
        }

        int numOfPeople = inFile.nextInt();
        System.out.println("***There are " + numOfPeople + " people.");
        Person people[] = new Person[numOfPeople];

        int index = 0;
        while(index < numOfPeople){
            String name = inFile.next();
            int age = inFile.nextInt();
            Person p = new Person(name, age);
            people[index] = p;
            index++;
        } //End while

        outFile.println("***There are " + numOfPeople + " people.");
        for(int i = 0; i < numOfPeople; i++){
            outFile.print(i+1 + ". ");
            people[i].printPerson(outFile);
        } //End for

        inFile.close();
        outFile.close();
    }
}