import java.util.*;

class Solution {
    private List<String> idList;    // 불량 사용자 아이디에 해당하는 제제 아이디 index 목록
    private Set<String> resultSet;  // 가능한 모든 제제 아이디 조합

    public int solution(String[] user_id, String[] banned_id) {
        idList = new ArrayList<>();   
        resultSet = new HashSet<>();   
        Arrays.sort(user_id);
        
        for (String ban: banned_id) {
            String tmp = "";
            for (int i = 0; i < user_id.length; i++) {
                if (isMatch(user_id[i], ban)) tmp += i;
            }
            idList.add(tmp);
        }
        combination(0, "");
        return resultSet.size();
    }
    
    private boolean isMatch(String toCheck, String format) {
        if (toCheck.length() != format.length()) return false;
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == '*') continue;
            if (format.charAt(i) != toCheck.charAt(i)) return false;
        }
        return true;
    }
    
    private void combination(int idx, String str) {
        if (idList.size() == idx) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            resultSet.add(new String(tmp));
            return;
        }
        
        String ids = idList.get(idx);
        for (int i = 0; i < ids.length(); i++) {
            if (str.indexOf(ids.charAt(i)) != -1) continue;
            combination(idx + 1, str + ids.charAt(i));
        }
    }
}