import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> list = new ArrayList<>();
        for (String s: strings) {
            list.add(s.charAt(n) + s);
        }
        Collections.sort(list);
        int idx = 0;
        for (String s : list) {
            answer[idx++] = s.substring(1);
        }
        return answer;
    }
}