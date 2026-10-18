#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

class Sort{
    public:
        vector<int> dataArr;

        Sort(){}

        void loadData(ifstream& inFile, vector<int>& dataArr, ofstream& logFile){
            logFile << "*** Entering loadData() ***\n";
            int data;

            while(inFile >> data){
                dataArr.push_back(data);

                logFile << "** The content of dataArr after push another data **\n";
                logFile << "Index\tData\n";
                logFile << "===========================\n";
                printDataArr(dataArr, logFile);
            }

            logFile << "*** Leaving loadData() ***\n";
        };

        void selectionSort(vector<int>& dataArr, int count, ofstream& logFile){
            logFile << "*** Entering selectionSort() ***\n";

            int i = 0;

            while(i < count-1){
                int minVal = dataArr[i];
                int minIndex = i;
                int j = i+1;

                while(j < count){
                    if(dataArr[j] < minVal){
                        minIndex = j;
                        minVal = dataArr[j];
                    }

                    j++;
                }

                if(minIndex != i){
                    int tmp = dataArr[i];
                    dataArr[i] = dataArr[minIndex];
                    dataArr[minIndex] = tmp;
                }

                logFile << "** Content of array after " << i << "-iteration of selection sort\n";
                logFile << "Index\tData\n";
                logFile << "====================\n";

                printDataArr(dataArr, logFile);

                i++;
            }

            logFile << "*** Leaving selectionSort() ***\n";
        };

        void printDataArr(vector<int>& dataArr, ofstream& fileOut){
            for(int i = 0; i < dataArr.size(); i++){
                fileOut << i << "\t" << dataArr[i] << endl;
            }
        };
};

int main(int argc, char** argv){
    if(argc != 4){
        cout << "Program needs 4 arguments.\n";
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

    Sort sorter;
    sorter.loadData(inFile, sorter.dataArr, logFile);

    outFile << "** The content of dataArr before sorting **\n";
    outFile << "Index\tData\n";
    outFile << "=======================\n";
    sorter.printDataArr(sorter.dataArr, outFile);

    int count = sorter.dataArr.size();
    sorter.selectionSort(sorter.dataArr, count, logFile);

    outFile << "** The content of array after sorting **\n";
    outFile << "Index\tData\n";
    outFile << "======================\n";
    sorter.printDataArr(sorter.dataArr, outFile);

    inFile.close();
    outFile.close();
    logFile.close();

    return 0;
}