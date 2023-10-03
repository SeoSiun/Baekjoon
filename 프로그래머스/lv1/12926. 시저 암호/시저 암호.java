class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        s.chars().map(c -> {
            if (c == ' ') return c;
            if (Character.isLowerCase(c) && c + n > 'z') {
                return c + n - 26;
            }
            if (!Character.isLowerCase(c) && c + n > 'Z') {
                return c + n - 26;
            }
            return (c + n);
        }).forEach(c -> answer.append((char) c));
        return answer.toString();
    }
}