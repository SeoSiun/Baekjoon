package Level3;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] argv) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result = solution(genres, plays);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> tmp = new ArrayList<>();
        HashMap<String, Integer> first = new HashMap<>();
        HashMap<String, Integer> second = new HashMap<>();
        HashMap<String, Integer> sum = new HashMap<>();
        int[] answer;

        for (int i = 0; i < genres.length; i++) {
            int f = first.getOrDefault(genres[i], -1);
            int s = second.getOrDefault(genres[i], -1);
            if (f == -1 || plays[f] < plays[i]) {
                if (f != -1 && (s == -1 || plays[s] < plays[f])) {
                    second.put(genres[i], f);
                }
                first.put(genres[i], i);
            }
            else {
                s = second.getOrDefault(genres[i], -1);
                if (s == -1 || plays[s] < plays[i])
                    second.put(genres[i], i);
            }
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        }
        // value를 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(sum.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry<String, Integer> e : entryList) {
            tmp.add(first.get(e.getKey()));
            if (second.containsKey(e.getKey()))
                tmp.add(second.get(e.getKey()));
        }
        answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}
