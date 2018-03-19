import java.util.*;
class Solution {
    // 逆波兰序列求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> op = new Stack<>();
        int n = tokens.length;
        for (String s : tokens) {
            if (Character.isDigit(s.charAt(0)) || s.length() > 1) {
                op.push(Integer.parseInt(s));
            } else {
                int b = op.pop();
                int a = op.pop(); 
                if (s.equals("+")) {
                    op.push(a + b);
                } else if (s.equals("-")) {
                    op.push(a - b);
                } else if (s.equals("*")) {
                    op.push(a * b);
                } else {
                    op.push(a / b);
                }
            }
        }
        return op.pop();
    }
    
}