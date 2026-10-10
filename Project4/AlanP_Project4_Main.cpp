#include <iostream>
#include <fstream>

using namespace std;

class counting{
    public:
        int charCountArr[256];

        counting(){
            initZero();
        }

        void initZero(){
            for(int i = 0; i < 256; i++){
                charCountArr[i] = 0;
            }
        }

        void computeCharCounts(ifstream& inFile, int charCountArr[], ofstream& logFile){
            logFile << "***Entering computerCharCounts method\n";
            
            char ch;
            while(inFile.get(ch)){
                int index = (unsigned char)ch;
                charCountArr[index]++;
                logFile << "***In computeCharCounts() char = " << ch << ", index = " << index << ", charCountArr[" << index << "] = " << charCountArr[index] << endl;
            }

            logFile << "***In computeCharCounts, print CharCountArr***\n";
            printCountArr(charCountArr, logFile);

            logFile << "***Leaving computeCharCounts method\n";
        }

        void printCountArr(int charCountArr[], ofstream& oFile){
            oFile << "ASCII\tChar\tCount\n";
            oFile << "=============================\n";
            for(int i = 0; i < 256; i++){
                if(charCountArr[i] == 0 || i == 13 || i == 23){
                    continue;
                }else if(i == 10){ //Print "newline" instead of converting to int
                    oFile << i << "\t\\n\t" << charCountArr[i] << endl;
                }else if(i == 32){ //Print "blank" instead of converting to int
                    oFile << i << "\tblank\t" << charCountArr[i] << endl;
                }else{
                    oFile << i << "\t" << char(i) << "\t" << charCountArr[i] << endl;
                }
            }
        }
};

int main(int argc, char** argv){
    if(argc != 4){
        cout << "Program needs 3 arguments\n";
        exit(1);
    }

    ifstream inFile(argv[1]);
    if(!inFile){
        cout << "inFile cannot be opened.\n";
        exit(1);
    }
    ofstream outFile(argv[2]);
    if(!outFile){
        cout << "outFile cannot be opened.\n";
        exit(1);
    }
    ofstream logFile(argv[3]);
    if(!logFile){
        cout << "logFile cannot be opened.\n";
        exit(1);
    }

    counting count;
    
    count.computeCharCounts(inFile, count.charCountArr, logFile);
    
    outFile << "***In main printing charCountArr\n";
    count.printCountArr(count.charCountArr, outFile);

    inFile.close();
    outFile.close();
    logFile.close();
}