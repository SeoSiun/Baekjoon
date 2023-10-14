import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            answer[1] += countZero(s);
            answer[0]++;
            s = s.replaceAll("0", "");
            s = convert(s.length());
        }
        return answer;
    }
    
    private int countZero(String s) {
        return s.length() - s.replaceAll("0", "").length();
    }
    
    private String convert(int c) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (c > 0) {
            sb.append(c % 2);
            c /= 2;
        }
        return sb.reverse().toString();
    }
}