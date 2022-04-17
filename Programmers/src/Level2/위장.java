package Level2;

import java.util.HashMap;

public class 위장 {
    public static void main(String[] argv) {
        String[][] ex1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] ex2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println("TEST1  :   " + solution(ex1));
        System.out.println("TEST2  :   " + solution(ex2));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        // 각 종류를 key로 해서 각 종류마다 의상 수를 셈.
        for (String[] c : clothes) {
            hm.put(c[1], hm.getOrDefault(c[1], 0) + 1);
        }
        // 그 종류 의상을 입지 않는 경우도 있으므로 각 종류마다 (총 의상 수 + 1)의 경우가 존재
        for (String key : hm.keySet()) {
            answer *= hm.get(key) + 1;
        }
        // 모든 종류의 의상을 입지 않는 경우를 빼줌.
        answer--;
        return answer;
    }
}
