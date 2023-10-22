import java.util.*;

class Solution {
    private Set<Integer> possibleNums;
    
    public int solution(String numbers) {
        boolean[] isVisited = new boolean[numbers.length()];
        possibleNums = new HashSet<>();
        getPossibleNums(numbers, isVisited, 0, "");
        return countPrime();
    }
    
    private void getPossibleNums(String numbers, boolean[] isVisited, int depth, String possibleNum) {
        if (possibleNum.length() > 0) {
            possibleNums.add(Integer.parseInt(possibleNum));
        }
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (depth == 0 && numbers.charAt(i) == '0') continue;
            if (!isVisited[i]) {
                isVisited[i] = true;
                getPossibleNums(numbers, isVisited, depth + 1, possibleNum + numbers.charAt(i));
                isVisited[i] = false;
            }
        }   
    }
    
    private int countPrime() {
        int count = 0;
        
        for (Integer num: possibleNums) {
            if (isPrime(num)) count++;
        }
        return count;
    }
    
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}