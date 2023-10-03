class Solution {
    public int[] solution(long n) {
        String strN = Long.toString(n);
        char[] charsN = strN.toCharArray();
        int[] answer = new int[charsN.length];

        for (int i = 0; i < charsN.length; i++) {
            answer[charsN.length - 1 - i] = Character.getNumericValue(charsN[i]);
        }
        return answer;
    }
}