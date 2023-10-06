class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int h = 1; h <= yellow; h++) {
            double w = (double)yellow / (double)h;
            if (!isInteger(w)) {
                continue;
            }
            int intW = (int)w;
            if((h + 2) * (intW + 2) == brown + yellow) {
                answer[0] = intW + 2;
                answer[1] = h + 2;
                break;
            }
        }
        return answer;
    }
    
    private boolean isInteger(double n) {
        return n == (int)n;
    }
}