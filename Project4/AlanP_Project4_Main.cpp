#include <iostream>
#include <fstream>

using namespace std;

class counting{
    private:    
        int charCountArr[256];
    
    public:
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