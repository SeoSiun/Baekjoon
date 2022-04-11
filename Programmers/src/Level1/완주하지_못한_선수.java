package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 완주하지_못한_선수 {
    public static void main(String[] argv) {
        System.out.println("Test1");
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println("Test2");
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println("Test3");
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {
        /***************** Method 1 ********************/
//        String answer = "";
//        ArrayList<String> _participant = new ArrayList<>(Arrays.asList(participant));
//        for (String c: completion) {
//            _participant.remove(c);
//        }
//        answer = _participant.get(0);
//        return answer;

        /***************** Method 2 ********************/
//        int i;
//
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        for (i = 0; i < completion.length; i++) {
//            if (!participant[i].equals(completion[i]))
//                return (participant[i]);
//        }
//        return participant[i];

        /***************** Method 3 ********************/
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String p : participant) hm.put(p, hm.getOrDefault(p, 0) + 1);
        for(String c : completion) hm.put(c, hm.get(c) - 1);

        for (String key: hm.keySet()) {
            if (hm.get(key) != 0) {
                answer =  key;
                break;
            }
        }
        return (answer);
    }
}
