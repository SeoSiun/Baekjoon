import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int start = 0;
        int indexOfBlank = s.indexOf(" ");
        while(indexOfBlank != -1) {
            convertWord(sb, s, start, indexOfBlank);
            start = indexOfBlank + 1;
            indexOfBlank = s.indexOf(" ", start);
        }
        convertWord(sb, s, start, s.length());
        return sb.toString();
    }
    
    private void convertWord(StringBuilder sb, String s, int start, int end) {
        for (int i = start; i < end; i++) {
            if ((i - start) % 2 == 0) {
                sb.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
            else {
                sb.setCharAt(i, Character.toLowerCase(s.charAt(i)));
            }
        }
    }
}