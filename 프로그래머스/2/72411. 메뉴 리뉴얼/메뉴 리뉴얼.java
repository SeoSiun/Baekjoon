import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> combinations;
        boolean[] visited;
        
        for (String order: orders) {
            combinations = new HashSet<>();
            visited = new boolean[order.length()];
            char[] tmp = order.toCharArray();
            Arrays.sort(tmp);
            for (int i : course) combination(tmp, "", visited, 0, i, combinations);
            combinations.stream().forEach(comb -> {
                map.put(comb, map.getOrDefault(comb, 0) + 1);
            });
        }
        
        List<String> answer = new ArrayList<>();
        for (int i : course) {
            int max = 0;
            for (String key: map.keySet()) {
                if (key.length() == i) {
                    max = Math.max(max, map.get(key));
                }
            }
            if (max < 2) break;
            for (String key: map.keySet()) {
                if (key.length() == i && map.get(key) == max) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    private void combination(char[] order, String comb, boolean[] visited, int start, int r, Set<String> combinations) {
        if(r == 0) {
            combinations.add(comb);
            return;
        } 
        if (comb.length() == order.length) return;

        for(int i=start; i<order.length; i++) {
            visited[i] = true;
            combination(order, comb + order[i], visited, i + 1, r - 1, combinations);
            visited[i] = false;
        }
    }
}