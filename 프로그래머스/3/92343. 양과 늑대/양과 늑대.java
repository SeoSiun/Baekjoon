class Solution {   
    private int max = 0;
    public int solution(int[] info, int[][] edges) {
        int[][] map = new int[info.length][info.length];
        for (int[] edge : edges) {
            map[edge[0]][edge[1]] = 1;
            map[edge[1]][edge[0]] = 1;
        }
        info[0] = -1;
        getSheeps(1, 0, info, map);
        return max;
    }
    
    private void getSheeps(int sheep, int wolf, int[] info, int[][] map) {
        max = Math.max(sheep, max);
        
        for (int i = 0; i < info.length; i++) {
            if (info[i] != -1) continue;
            
            for (int j = 0; j < info.length; j++) {
                if (info[j] == -1 || map[i][j] == 0) continue;
                
                int[] clone = info.clone();
                clone[j] = -1;
                if (info[j] == 1 && wolf + 1 < sheep) {
                    getSheeps(sheep, wolf + 1, clone, map);
                }
                else if (info[j] == 0) {
                    getSheeps(sheep + 1, wolf, clone, map);
                }
            }
        }
    }
}