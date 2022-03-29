#include <string>
#include <vector>

using namespace std;

string solution(string new_id) {
    int i;
    string answer = "";

    for(i=0; i<new_id.length(); i++){
        // level 1
        if(int(new_id[i])<=90 && int(new_id[i])>=65){
            string tmp;
            tmp += char(int(new_id[i])+32);
            new_id.replace(i,1,tmp);
        }
    }
    // level 2
    for(i=0; i<new_id.length(); i++){
        if((int(new_id[i])<=122 && int(new_id[i])>=97) || (int(new_id[i])<=57 && int(new_id[i])>=48) || new_id[i]=='-' || new_id[i]=='_' || new_id[i]=='.'){
            answer += new_id[i];
        }
    }
    // level 3
    for(i=0; i<answer.length()-1; i++){
        if(answer[i] == '.' && answer[i+1] == '.'){
            answer = answer.substr(0,i) + answer.substr(i+1);
            i--;
        }
    }
    // level 4
    if(answer[0] == '.') answer = answer.substr(1);
    if(answer[answer.length()-1] == '.') 
        answer = answer.substr(0,answer.length()-1);
    // level 5
    if(answer.length() == 0) answer = "a";
    // level 6
    if(answer.length() >= 16) answer = answer.substr(0,15);
    if(answer[answer.length()-1] == '.') 
        answer = answer.substr(0,answer.length()-1);
    // level 7
    if(answer.length() <= 2){
        while(answer.length() < 3){
            answer += answer[answer.length()-1];
        }
    }
    return answer;
}