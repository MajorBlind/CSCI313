#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

class treeNode{
    public: 
        int data;
        treeNode* left;
        treeNode* right;

        treeNode(int data, treeNode* left, treeNode* right){
            this->data = data;
            this->left = left;
            this->right = right;
        }
};

class binTree{
    public:
        treeNode* root;
        vector<int> dataArr;

        void loadData(ifstream& inFile, vector<int>& dataArr, ofstream& logFile){
            logFile << "*** Entering loadData() ***\n";
            int data;

            while(inFile >> data){
                dataArr.push_back(data);

                logFile << "** The content of dataArr after push anohter data **\n";
                logFile << "Index\tData\n";
                logFile << "=================================\n";
                printArr(dataArr, logFile);
            }
        }

        bool checkData(const vector<int>& dataArr, ofstream& outFile){
            for(int i = 1; i < (int)dataArr.size(); i++){
                if(dataArr[i] < dataArr[i-1]){
                    outFile << "ERROR! The input data is out of order at index = " << i << "; integer = " << dataArr[i] << endl;
                    return false;
                }
            }
            return true;
        }

        void printArr(vector<int>& dataArr, ofstream& fileOut){
            for(int i = 0; i < dataArr.size(); i++){
                fileOut << i << "\t" << dataArr[i] << endl;
            }
        }

        treeNode* buildBinTree(vector<int>& inArr, int leftIndex, int rightIndex, ofstream& logFile){
            logFile << "*** Entering buildBinTree; leftIndex = " << leftIndex << " rightIndex = " << rightIndex;

            if(leftIndex > rightIndex){
                return nullptr;
            }

            int midIndex = (leftIndex + rightIndex + 1) / 2;
            int size = rightIndex - leftIndex + 1;
            treeNode* newNode = new treeNode(-1, nullptr, nullptr);
            logFile << "midIndex = " << midIndex << "; size = " << size << endl;

            if(size == 1){
                newNode->data = dataArr[leftIndex];
            }else{
                newNode->left = buildBinTree(dataArr, leftIndex, midIndex - 1, logFile);
                newNode->right = buildBinTree(dataArr, midIndex + 1, rightIndex, logFile);
            }

            logFile << "*** Leaving buildBinTree(); newNode's data is " << newNode->data << endl;

            return newNode;
        }

        void preOrder(treeNode* node, ofstream& outFile){
            if(node != nullptr){
                outFile << node->data << endl;
                preOrder(node->left, outFile);
                preOrder(node->right, outFile);
            }
        }

        void inOrder(treeNode* node, ofstream& outFile){
            if(node != nullptr){
                inOrder(node->left, outFile);
                outFile << node->data << endl;
                inOrder(node->right, outFile);
            }
        }

        void postOrder(treeNode* node, ofstream& outFile){
            if(node != nullptr){
                postOrder(node->left, outFile);
                postOrder(node->right, outFile);
                outFile << node->data << endl;
            }
        }
};

int main(int argc, char** argv){
    if(argc != 4){
        cout << "Program needs 3 arguments.\n";
        exit(1);
    }

    ifstream inFile(argv[1]);
    if(!inFile){
        cout << "Cannot open inFile\n";
        exit(1);
    }
    ofstream outFile(argv[2]);
    if(!outFile){
        cout << "Cannot open outFile\n";
        exit(1);
    }
    ofstream logFile(argv[3]);
    if(!logFile){
        cout << "Cannot open logFile\n";
        exit(1);
    }

    binTree bt;

    bt.loadData(inFile, bt.dataArr, logFile);

    bool flag = bt.checkData(bt.dataArr, outFile);
    if(flag == false){
        inFile.close();
        outFile.close();
        logFile.close();
        exit(1);
    }

    outFile << "** The content of dataAry loaded from inFile **\n";
    outFile << "Index data\n";
    outFile << "=============\n";
    bt.printArr(bt.dataArr, outFile);

    int count = bt.dataArr.size();

    bt.root = bt.buildBinTree(bt.dataArr, 0, count - 1, logFile);

    outFile << "*** Below is the preOrder of the binary tree ***\n";
    bt.preOrder(bt.root, outFile);

    outFile << "*** Below is the inOrder of the binary tree ***\n";
    bt.inOrder(bt.root, outFile);
    outFile << "*** Below is the postOrder of the binary tree ***\n";
    bt.postOrder(bt.root, outFile);

    inFile.close();
    outFile.close();
    logFile.close();
    return 0;
}