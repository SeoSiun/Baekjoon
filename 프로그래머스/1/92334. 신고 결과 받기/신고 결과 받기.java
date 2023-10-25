import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> idList = Arrays.asList(id_list);
        Set<String> reportSet = new HashSet(Arrays.asList(report));
        int[] reportCnt = new int[id_list.length];   // id별 신고당한 횟수
        Map<Integer, List<Integer>> reportMap = new HashMap<>();   // id별 신고자 목록
        int[] result = new int[id_list.length];   // id별 받은 결과메일 수
        
        for (String r: reportSet) {
            String[] tmp = r.split(" ");
            int reported = idList.indexOf(tmp[1]);
            int reporting = idList.indexOf(tmp[0]);
            
            reportCnt[reported]++;
            List<Integer> reportings = reportMap.getOrDefault(reported, new ArrayList<>());
            reportings.add(reporting);
            reportMap.put(reported, reportings);
        }
        
        for (Integer key: reportMap.keySet()) {
            if (reportCnt[key] >= k) {
                for(Integer i: reportMap.get(key)) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}