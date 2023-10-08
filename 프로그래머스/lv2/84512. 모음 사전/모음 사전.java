import java.util.*;

class Solution {
    private static final char[] chars = {'A', 'E', 'I', 'O', 'U'};

	public int solution(String word) {
        List<String> list = new ArrayList<>();
        dfs("", list);
        int cnt = 0;
        for (String s: list) {
            if (s.equals(word)) return cnt;
            cnt++;
        }
        return 0;
	}
    
    private void dfs(String str, List<String> list) {
        list.add(str);
        if (str.length() == 5) return;
        for (int i = 0; i < chars.length; i++) {
            dfs(str + chars[i], list);
        }
    }
}