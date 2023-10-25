import java.util.*;

class Solution {
    private int n;
    private int[][] costs;
    
    public int solution(int n, int[][] costs) {
        this.n = n;
        this.costs = new int[n][n];
        for (int[] cost: costs) {
            this.costs[cost[0]][cost[1]] = cost[2];
            this.costs[cost[1]][cost[0]] = cost[2];
        }
        List<Integer> connected = new ArrayList<>();
        connected.add(0);
        return buildBridge(connected, 0);
    }
    
    // connected: 이미 연결된 섬 목록, cost: 현재까지 비용 합계
    private int buildBridge(List<Integer> connected, int cost) {        
        if (connected.size() == n) {
            return cost;
        }
        
        // connected와 연결된 edge 중 가장 비용이 작은 edge를 찾아서 확장
        int minNode = -1;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (connected.indexOf(i) == -1) continue;  // 이미 연결된 섬
            for (int j = 0; j < n; j++) {
                if (connected.indexOf(j) != -1) continue;  // 연결되지 않은 섬
                if(costs[i][j] > 0 && minCost > costs[i][j]) {
                    minNode = j;
                    minCost = Math.min(minCost, costs[i][j]);
                }
            }
        }
        connected.add(minNode);
        return buildBridge(connected, cost + minCost);
    }
}
