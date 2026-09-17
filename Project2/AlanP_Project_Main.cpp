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
}

// Main
