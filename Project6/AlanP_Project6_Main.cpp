#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

class treeNode{
    public: 
        int data;
        treeNode* left;
        treeNode* right;
};

class binTree{
    public:
        treeNode* root;
        vector<int> dataArr;

        void loadData(ifstream& inFile, vector<int>& dataArr, ofstream& logFile){}

        bool checkData(vector<int>& dataArr){}

        void printArr(vector<int>& dataArr, ofstream& fileOut){}

        treeNode* buildBinTree(vector<int>& inArr, int leftIndex, int rightIndex, ofstream& logFile){}

        void preOrder(treeNode* node, ofstream& outFile){}

        void inOrder(treeNode* node, ofstream& outFile){}

        void postOrder(treeNode* node, ofstream& outFile){}
};

int main(int argc, char** argv){
    return 0;
}