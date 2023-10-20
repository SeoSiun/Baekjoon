import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] sNumbers = new String[numbers.length];
        int idx = 0;
        for (int number: numbers) {
            sNumbers[idx++] = "" + number;
        }
        Arrays.sort(sNumbers, (s1, s2) -> {
            return (s2 + s2 + s2 + s2).compareTo(s1 + s1 + s1 + s1);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String sNumber: sNumbers) {
            sb.append(sNumber);
        }
        String answer = sb.toString().replaceAll("^[0]+", "");
        if (answer.length() == 0) return "0";
        return answer;
    }
}