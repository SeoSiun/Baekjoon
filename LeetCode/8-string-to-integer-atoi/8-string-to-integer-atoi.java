class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int i = 0;
        int num = 0;
        
        s = s.trim();
        if (s.length() == 0)
            return 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }
        for (; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (isOutOfRange(num, s.charAt(i) - '0', sign)) {
                    if (sign == 1)
                        return 2147483647;
                    if (sign == -1)
                        return -2147483648;
                }
                num = num * 10 + s.charAt(i) - '0';
            }
            else
                break;
        }
        return sign * num;
    }
                    
    private boolean isOutOfRange(int num, int newNum, int sign) {
        if (sign == 1 && (num > 214748364 || (num == 214748364 && newNum > 7)))
            return true;
        if (sign == -1 && (num > 214748364 || (num == 214748364 && newNum > 8)))
            return true;
        return false;
    }
}