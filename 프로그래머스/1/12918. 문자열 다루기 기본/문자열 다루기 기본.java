class Solution {
    public boolean solution(String s) {        
        int originalLength = s.length();
        
        if (originalLength != 4 && originalLength != 6) {
            return false;
        }
        
        int onlyNumberLength = s.replaceAll("[^0-9]", "").length();
        
        return originalLength == onlyNumberLength;
    }
}