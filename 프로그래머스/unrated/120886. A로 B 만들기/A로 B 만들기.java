import java.util.*;

class Solution {
    public int solution(String before, String after) {        
        for (char c : before.toCharArray()) {
            while (count(before, c) != count(after, c)) {
                return 0;
            }
        }
        return 1;
    }
    
    private int count(String str, char c) {
        return str.length() - str.replace(String.valueOf(c), "").length();
    }
}