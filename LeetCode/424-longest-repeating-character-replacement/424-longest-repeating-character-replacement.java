class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int start = 0;
        int main = 0;
        int max = 0;
        
        for (int end = 0; end < s.length() ; end++) {
            main = Math.max(main, ++cnt[s.charAt(end) - 'A']);
            if (end - start + 1 - main > k) {
                --cnt[s.charAt(start) - 'A'];
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}