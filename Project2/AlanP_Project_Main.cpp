#include <iostream>
#include <fstream>

using namespace std;

// Sort Class
class Sort{
    private:
        int count;
        string* dataAry; // Size of count, dynamically allocate at runtime
    
    public:
        Sort(int count, string* dataAry){
            this->count = count;
            this->dataAry = dataAry;
        }

        int countData(ifstream& inFile, ofstream& logFile){
            logFile << "Entering countData()\n";
            
            int count = 0;
            string word;
            while(inFile >> word){
                count++;
            }

            logFile << "Leaving countData() - Data count: " + count << endl;
            return count;
        }

        void loadData(ifstream& inFile, string* dataAry, int count, ofstream& logFile){
            logFile << "Entering loadData()" << endl;

            int index = 0;
            string word;
            while(index < count && inFile >> word){
                dataAry[index] = word;
                index++;
            }

            logFile << "Leaving loadData()" << endl;
        }

        void bubbleSort(){
            // Implement bubble sort
        }

        void selectionSort(){
            // Implement selectionSort
        }

        void printDataAry(string* dataAry, ofstream& fileOut, ofstream& logFile){
            logFile << "Entering printDataAry()" << endl;
            cout << "Index\tData" << endl;
            cout << "=======================" << endl;

            for(int i = 0; i < count; i++){
                cout << i << "\t" << dataAry[i] << endl;
                fileOut << i << "\t" + dataAry[i] << endl;
            }
        }
};

// Main
