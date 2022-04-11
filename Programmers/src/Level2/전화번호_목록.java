package Level2;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호_목록 {
    public static void main(String[] argv) {
        System.out.println("Test1");
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println("Test2");
        System.out.println(solution(new String[]{"123","456","789"}));
        System.out.println("Test3");
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }

    public static boolean solution(String[] phone_book) {
        /************** method1 ******************/
//        Arrays.sort(phone_book);
//
//        for(int i = 0; i < phone_book.length - 1; i++) {
//            if (phone_book[i + 1].startsWith(phone_book[i]))
//                return false;
//        }
//        return true;

        /************** method2 ******************/
        HashMap<String, Integer> hm = new HashMap<>();
        for (String p : phone_book)
            hm.put(p, 0);
        for (String p : phone_book) {
            for (int i = 0; i < p.length(); i++) {
                if (hm.containsKey(p.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
