class Solution {
    private int min = 0;
    
    public int solution(String begin, String target, String[] words) {
        convert(begin, target, words, 0);
        return min;
    }
    
    private void convert(String cur, String target, String[] words, int cnt) {
        if (target.equals(cur)) {
            if (min == 0) min = cnt;
            else min = Math.min(min, cnt);
            return;
        }
        if (cnt == words.length) {
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) continue;
            if (isValidToConvert(word, cur)) {
                String[] clone = words.clone();
                clone[i] = "";
                convert(word, target, clone, cnt + 1);
            }
        }
    }
    
    private boolean isValidToConvert(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
                if (diffCnt >= 2) return false;
            }
        }
        return true;
    }
}