#include <string>
#include <vector>
#include <iostream>

using namespace std;

int getDistance(int pos, int dest){
    int distance;

    switch (abs(dest-pos))
    {
        case 0:
            distance = 0;
            break;
        case 1:
            distance = 1;
            break;
        case 2:
            distance = 2;
            break;
        case 3:
            distance = 1;
            break;
        case 4:
            distance = 2;
            break;
        case 5:
            distance = 3;
            break;
        case 6:
            distance = 2;
            break;
        case 7:
            distance = 3;
            break;
        case 8:
            distance = 4;
            break;
        case 9:
            distance = 3;
            break;
        case 10:
            distance = 4;
            break;
        default:
            break;
    }
    return distance;
}

string solution(vector<int> numbers, string hand) {
    string answer = "";

    // cf) 1~9 == 1~9 | 10 == * | 11 == 0 | 12 == #
    int leftPos = 10;       
    int rightPos = 12; 
    int leftDistance;
    int rightDistance;
    int i;    
    
    vector<int>::iterator iter;
    for(iter = numbers.begin(); iter != numbers.end() ; iter++){
        switch (*iter)
        {
        case 1:
        case 4:
        case 7:
            leftPos = *iter;
            answer += 'L';
            break;
        case 3:
        case 6:
        case 9:
            rightPos = *iter;
            answer += 'R';
            break;
        default:
            int dest = *iter;
            if(dest == 0) dest = 11;
            leftDistance = getDistance(leftPos, dest);
            rightDistance = getDistance(rightPos, dest);
        
            if(leftDistance < rightDistance){
                leftPos = dest;
                answer += 'L';
            }
            else if(leftDistance > rightDistance) {
                rightPos = dest;
                answer += 'R';
            }
            else if(hand.compare("left")==0) {
                leftPos = dest;
                answer += 'L';
            }
            else{
                rightPos = dest;
                answer += 'R';
            }
        }
    }
    return answer;
}