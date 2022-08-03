class Solution {
    public String longestPalindrome(String s) {
        int sLen = s.length();
        int mLen = 0;
        String max = "";
        String tmp = "";
        
        for (int i = 0; i < sLen; i++) {
            if (sLen - i < mLen)
                break;
            for(int j = sLen; j > i; j--) {
                tmp = s.substring(i, j);
                if (isPalindromic(tmp) && mLen < tmp.length()) {
                    max = tmp;
                    mLen = tmp.length();
                }
                if (j - i < mLen)
                    break;
            }
        }
        return max;
    }
    
    private boolean isPalindromic(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}