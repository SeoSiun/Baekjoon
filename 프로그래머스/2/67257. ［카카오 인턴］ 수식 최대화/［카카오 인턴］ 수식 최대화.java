import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private static final List<List<String>> priorities = List.of(
        Arrays.asList("*", "+", "-"),
        Arrays.asList("*", "-", "+"),
        Arrays.asList("+", "*", "-"),
        Arrays.asList("+", "-", "*"),
        Arrays.asList("-", "+", "*"),
        Arrays.asList("-", "*", "+")
    );
    
    public long solution(String expression) {
        List<String> operators = new ArrayList<>();
        List<Long> operands = new ArrayList<>();
        long max = 0;
        
        parse(expression, operators, operands);
        for (List<String> priority: priorities) {
            max = Math.max(calculate(new ArrayList<>(operators), new ArrayList<>(operands), priority), max);
        }
        return max;
    }
    
    private void parse(String expression, List<String> operators, List<Long> operands) {
        StringBuilder sb = new StringBuilder();
        
        expression.chars().forEach(c -> {
            if (c == '+' || c == '-' || c == '*') {
                operators.add(Character.toString(c));
                operands.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
            }
            else {
                sb.append((char)c);
            }
        });
        operands.add(Long.parseLong(sb.toString()));
    }
    
    private long calculate(List<String> operators, List<Long> operands, List<String> priority) {        
        for (String curOp: priority) {
            for (int i = 0; i < operators.size(); i++) {
                if (curOp.equals(operators.get(i))) {
                    operate(operands,operators, i--);
                }
            }
        }
        return Math.abs(operands.get(0));
    }
    
    private void operate(List<Long> operands, List<String> operators, int i) {
        String op = operators.get(i);
        Long result;
                
        if (op.equals("+")) {
            result = operands.get(i) + operands.get(i + 1);
        }
        else if (op.equals("-")) {
            result = operands.get(i) - operands.get(i + 1);
        }
        else {
            result = operands.get(i) * operands.get(i + 1);
        }
        operators.remove(i);
        operands.remove(i);
        operands.remove(i);
        operands.add(i, result);
    }
}