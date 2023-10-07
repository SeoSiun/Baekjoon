class Solution {
    private static final char P = 'P';
    private static final char X = 'X';
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int index = 0;
        for (String[] place: places) {
            answer[index++] = checkValid(place);
        }
        return answer;
    }
    
    private int checkValid(String[] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length(); j++) {
                if (place[i].charAt(j) == P) {
                    if (!isValid(place, i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    private boolean isValid(String[] place, int i, int j) {
        if (i + 1 < 5 && place[i + 1].charAt(j) == P) return false;
        if (j + 1 < 5 && place[i].charAt(j + 1) == P) return false;
        if (i + 2 < 5 && place[i + 2].charAt(j) == P && place[i + 1].charAt(j) != X) return false;
        if (j + 2 < 5 && place[i].charAt(j + 2) == P && place[i].charAt(j + 1) != X) return false;
        if (i + 1 < 5 && j + 1 < 5 && place[i + 1].charAt(j + 1) == P) {
            if (!(place[i].charAt(j + 1) == X && place[i + 1].charAt(j) == X)) {
                return false;
            }
        }
        if (i + 1 < 5 && j - 1 >= 0 && place[i + 1].charAt(j - 1) == P) {
            if (!(place[i].charAt(j - 1) == X && place[i + 1].charAt(j) == X)) {
                return false;
            }
        }
        return true;

    }
}