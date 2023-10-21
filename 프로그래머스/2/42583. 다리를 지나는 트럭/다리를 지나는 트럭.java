import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int curWeight = 0;
        int done = 0;
        int idx = 0;
        
        
        while (done < truck_weights.length) {
            if (idx < truck_weights.length && curWeight + truck_weights[idx] <= weight) {
                curWeight += truck_weights[idx];
                bridge.add(truck_weights[idx++]);
            }
            else {
                bridge.add(0);
            }
            
            if (bridge.size() == bridge_length) {
                int weightToRemove = bridge.remove();
                if (weightToRemove > 0) {
                    done++;
                    curWeight -= weightToRemove;
                }
            }
            time++;
        }
        return time + 1;
    }
}