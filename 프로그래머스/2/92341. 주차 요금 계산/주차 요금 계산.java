import java.util.*;

class Solution {
    private static final int END_TIME = 23 * 60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalTime = getTotalTime(records);
        
        List<String> carNums = new ArrayList<>(totalTime.keySet());
        Collections.sort(carNums);
        
        int[] answer = new int[carNums.size()];
        int idx = 0;
        for (String carNum: carNums) {
            answer[idx++] = calculateFee(totalTime.get(carNum), fees);
        }
        return answer;
    }
    
    private Map<String, Integer> getTotalTime(String[] records) {
        Map<String, Integer> inRecord = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        
        for (String record: records) {
            String[] splited = record.split(" ");
            if (splited[2].equals("IN")) {
                String[] time = splited[0].split(":");
                inRecord.put(splited[1], Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
            }
            else {
                String[] time = splited[0].split(":");
                int diff = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) - inRecord.get(splited[1]);
                inRecord.put(splited[1], END_TIME);
                totalTime.put(splited[1], totalTime.getOrDefault(splited[1], 0) + diff);
            }
        }
                
        for (String key: inRecord.keySet()) {
            int diff = END_TIME - inRecord.get(key);
            totalTime.put(key, totalTime.getOrDefault(key, 0) + diff);
        }
        return totalTime;
    }
    
    private int calculateFee(int totalTime, int[] fees) {
        if (totalTime <= fees[0]) return fees[1];
        return fees[1] + (int)Math.ceil((totalTime - fees[0]) / (double)fees[2]) * fees[3];
    }
}