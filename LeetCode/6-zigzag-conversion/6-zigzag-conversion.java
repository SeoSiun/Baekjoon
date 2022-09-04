class Solution {
    public String convert(String s, int numRows) {
        StringBuilder rows[] = new StringBuilder[numRows];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();
        
        if (numRows == 1 || numRows == s.length())
            return s;
        
        int index = 0;
        int sign = 1;
        for (int i = 0; i< s.length(); i++) {
            rows[index].append(s.charAt(i));
            index += sign;
            if (index == 0 || index == numRows - 1)
                sign *= -1;
        }
        for (int i = 0; i < numRows; i++)
            result.append(rows[i]);
        return result.toString();
    }
}