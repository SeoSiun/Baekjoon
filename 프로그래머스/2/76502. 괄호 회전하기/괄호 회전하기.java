import java.util.*;

class Solution {
    private static List<Character> LEFT = List.of('(', '[', '{');
    private static List<Character> RIGHT = List.of(')', ']', '}');
    
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (isValid(rotate(s, i))) {
                answer++;
            }
        }
        return answer;
    }
    
    private String rotate(String s, int i) {
        return s.substring(i) + s.substring(0, i);
    }
    
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (LEFT.contains(c)) {
                stack.push(c);
            }
            else {
                if (stack.size() == 0) {
                    return false;
                }
                if (LEFT.indexOf(stack.pop()) != RIGHT.indexOf(c)) {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}