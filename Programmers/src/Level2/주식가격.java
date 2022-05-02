package Level2;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] argv) {
        int[] p1 = {1, 2, 3, 2, 3};
        int[] p2 = {5, 8, 6, 2, 4, 1};

        // [4, 3, 1, 1, 0]
        System.out.println("ex1");
        for (int r: solution(p1)) {
            System.out.println(r);
        }
        System.out.println();

        // [3, 1, 1, 2, 1, 0]
        System.out.println("ex2");
        for (int r: solution(p2)) {
            System.out.println(r);
        }
        System.out.println();
    }

    public static int[] solution(int[] prices) {
        /******* TIME OUT *********/
//        int[] answer = new int[prices.length];
//        int[] is_end = new int[prices.length];
//
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (is_end[j] == 1) continue;
//                answer[j]++;
//                if (prices[j] > prices[i]) is_end[j] = 1;
//            }
//        }
//        return answer;


        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            answer[stack.peek()] = prices.length - 1 - stack.peek();
            stack.pop();
        }
        return answer;
    }
}
