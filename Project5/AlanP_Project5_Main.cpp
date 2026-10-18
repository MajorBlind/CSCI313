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