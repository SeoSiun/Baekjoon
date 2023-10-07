import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        Set<Character> set = new LinkedHashSet<>();
        for (char c: my_string.toCharArray()) {
            set.add(c);
        }
        for(Character c: set) {
            answer += c;
        }
        return answer;
    }
}