import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, getCompressedLength(i, s));
        }
        return answer;
    }

    private int getCompressedLength(int n, String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int cnt = 1;
        String prev = s.substring(i, i + n);
        i += n;
        while (i < s.length()) {
            while (i + n <= s.length() && s.substring(i, i + n).equals(prev)) {
                cnt++;
                i += n;
            }
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(prev);
            cnt = 1;
            if (i + n < s.length()) {
                prev = s.substring(i, i + n);
                i += n;
            } else break;
        }
        sb.append(s.substring(i));
        return sb.toString().length();
    }
}