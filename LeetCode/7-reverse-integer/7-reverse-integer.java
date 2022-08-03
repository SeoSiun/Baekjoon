class Solution {
    public int reverse(int x) {
        int sign = 1;
        int newX = 0;
        int len;
        
        if (x == -2147483648)
            return 0;
        if (x < 0) {
            sign = -1;
            x *= -1;
        }
        len = getLength(x);
        for (int i = 0; i < len; i++) {
            if (newX > 214748364 || (newX == 214748364 && x % 10 > 7))
                return 0;
            newX = newX * 10 + x % 10;
            x /= 10;
        }
        return sign * newX;
    }
    
    private int getLength(int x) {
        int len = 0;
        
        while (x > 0) {
            x /= 10;
            len++;
        }
        return len;
    }
}