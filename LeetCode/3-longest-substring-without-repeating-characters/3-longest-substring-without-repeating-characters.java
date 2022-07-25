class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max_len = 0;
        int pos;
        
        for (int i = 1; i < s.length(); i++) {
            pos = s.substring(start, i).indexOf(s.charAt(i));
            if (pos == -1) 
                end = i;
            else {
                if (end - start + 1 > max_len) 
                    max_len = end - start + 1;
                start += pos + 1;
                end = start;
            }
        }
        if (s.length() != 0 && end - start + 1 > max_len) 
            max_len = end - start + 1;
        return max_len;
    }
}