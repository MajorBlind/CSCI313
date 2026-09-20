#include <iostream>
#include <fstream>

using namespace std;

// Sort Class
class Sort{
    private:
        static int count;
        string* dataAry; // Size of count, dynamically allocate at runtime
    
    public:
        Sort(int count, string* dataAry){
            this->count = count;
            this->dataAry = dataAry;
        }

        static int countData(ifstream& inFile, ofstream& logFile){
            logFile << "Entering countData()\n";
            
            int count = 0;
            string word;
            while(inFile >> word){
                count++;
            }

            logFile << "Leaving countData() - Data count: " << count << endl;
            return count;
        }

        static void loadData(ifstream& inFile, string* dataAry, int count, ofstream& logFile){
            logFile << "Entering loadData()" << endl;

            int index = 0;
            string word;
            while(index < count && inFile >> word){
                dataAry[index] = word;
                index++;
            }

            logFile << "Leaving loadData()" << endl;
        }

        static void bubbleSort(string* dataAry, int count, ofstream& outFile, ofstream& logFile){
            logFile << "Entering bubbleSort()\n";

            string tmp;
            int last = count - 1;
            bool swapFlag = true;
            
            while(swapFlag == true){
                int i = 0;
                swapFlag = false;
                while(i < last){
                    if(dataAry[i] > dataAry[i+1]){
                        tmp = dataAry[i];
                        dataAry[i] = dataAry[i+1];
                        dataAry[i+1] = tmp;
                        swapFlag = true;
                    }
                    i++;
                }
                logFile << "**Content of Array after one iteration of bubble sort. Last = \n";
                printDataAry(dataAry, outFile, logFile);
                last = last - 1;
            }

            logFile << "Leaving bubbleSort()" << endl;
        }

        static void selectionSort(string* dataAry, int count, ofstream& outFile, ofstream& logFile){
            // Step 0
            logFile << "Entering selectionSort()\n";

            // Step 1
            int i = 0;

            // Step 10
            while(i < count-1){
                // Step 2
                string minVal = dataAry[i];
                int minIndex = i;
                int j = i+1;

                // Step 5 (Steps 3-4)
                while(j < count){
                    // Step 3
                    if(dataAry[j] < minVal){
                        minIndex = j;
                        minVal = dataAry[j];
                    }

                    // Step 4
                    j++;
                }

                // Step 6
                if(minIndex != i){
                    string tmp = dataAry[i];
                    dataAry[i] = dataAry[minIndex];
                    dataAry[minIndex] = tmp;
                }

                // Step 7
                logFile << "Content of Array after " << i << "-th iteration of selection sort\n";
                
                // Step 8
                printDataAry(dataAry, outFile, logFile);

                // Step 9
                i++;
            }

            // Step 11
            logFile << "Leaving selectionSort()" << endl;
        }

        static void printDataAry(string* dataAry, ofstream& fileOut, ofstream& logFile){
            logFile << "Entering printDataAry()" << endl;
            cout << "Index\tData" << endl;
            cout << "=======================" << endl;

            for(int i = 0; i < count; i++){
                cout << i << "\t" << dataAry[i] << endl;
                fileOut << i << '\t' << dataAry[i] << endl;
            }
        }
};

int Sort::count = 0;

// Main
int main(int argc, char** argv){
    if(argc != 4){
        cout << "Command line needs 3 arguments";
        exit(1);
    }
    ifstream inFile(argv[1]);
    if(!inFile){
        cout << "Input file cannot open";
        exit(1);
    }
    ofstream outFile(argv[2]);
    if(!outFile){
        cout << "Output file cannot open";
        exit(1);
    }
    ofstream logFile(argv[3]);
    if(!logFile){
        cout << "Log file cannot open";
        exit(1);
    }

    int count = Sort::countData(inFile, logFile);
    logFile << "In main() count = " << count << endl;

    string* dataAry = new string[count];
    inFile.close();

    inFile.open(argv[1]);
    Sort::loadData(inFile, dataAry, count, logFile);

    outFile << "**Printing data before sorting**\n";
    Sort::printDataAry(dataAry, outFile, logFile);

    cout << "You have a choice of Bubble-sort or Selection-sort in program.\n";
    cout << "Enter 1 for bubble-sort, enter 2 for selection-sort.\n";
    int whichSort;
    cin >> whichSort;

    if(whichSort == 1){
        outFile << "**You select bubble-sort.**\n";
        Sort::bubbleSort(dataAry, count, outFile, logFile);
        outFile << "**Result of bubble-sort on data**\n";
        Sort::printDataAry(dataAry, outFile, logFile);
    }if(whichSort == 2){
        outFile << "**You select selection-sort.**\n";
        Sort::selectionSort(dataAry, count, outFile, logFile);
        outFile << "**Result of selection-sort on data**\n";
        Sort::printDataAry(dataAry, outFile, logFile);
    }else{
        cout << "Sorry! You must enter either 1 for bubble-sort or 2 for selection-sort!\n";
    }

    delete[] dataAry;
    inFile.close();
    outFile.close();
    logFile.close();
    return 0;
}