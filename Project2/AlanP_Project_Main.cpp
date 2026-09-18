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

        int countData(ifstream inFile, ofstream& logFile){
            logFile << "Entering countData()\n";
        }

        void loadData(){}

        void bubbleSort(){}

        void selectionSort(){}

        void printDataAry(string* dataAry, ofstream fileOut){
            cout << "Index\tData" << endl;
            cout << "=======================" << endl;
        }
}

// Main
