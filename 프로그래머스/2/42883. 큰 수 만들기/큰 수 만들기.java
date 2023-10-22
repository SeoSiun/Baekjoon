class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int maxIdx = 0;
        
        while (k > 0) {
            if (number.length() == 1 && k == 1) {
                number = "";
                break;
            }
            String tmp = number.substring(0, k + 1);
            char max = (char)tmp.chars().max().orElse(0);
            answer += max;
            maxIdx = number.indexOf(max);
            number = number.substring(maxIdx + 1, number.length());
            k -= maxIdx;
        }
        answer += number;
        return answer;
    }
}