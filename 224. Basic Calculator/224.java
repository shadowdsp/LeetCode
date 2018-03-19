import java.util.*;

class Solution {
    public int calculate(String s) {
        ArrayList<String> str = new ArrayList<>();
        int n = s.length();
        boolean flag = false;
        String num = "";
        for (int i = 0; i < n; i++) { // 变成中缀表达式
            if (s.charAt(i) == ' ') continue;
            if (Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
                flag = true;
            } else {
                if (flag) {
                    str.add(num);
                    num = "";
                    flag = false;
                }
                str.add(String.valueOf(s.charAt(i)));
            }
        }
        if (!num.equals("")) str.add(num);

        // 变成后缀表达式（逆波兰序列）
        Stack<String> op = new Stack<>();
        Stack<String> el = new Stack<>();
        for (String ss : str) {
            if (ss.length() > 1 || Character.isDigit(ss.charAt(0))) {
                el.push(ss);
            } else {
                if (ss.equals("(")) {
                    op.push(ss);
                } else if (ss.equals(")")) {
                    while (!op.peek().equals("("))
                        el.push(op.pop());
                    op.pop(); // 删除掉左括号
                } else {
                    if (op.empty()) {
                        op.push(ss);
                    } else if (ss.equals("(") || ss.equals(")")) {
                        op.push(ss);
                    } else if (check(ss, op.peek())) {
                        op.push(ss);
                    } else {
                        el.push(op.pop());
                        op.push(ss);
                    }
                }
            }
        }
        while (!op.empty()) el.push(op.pop());
        str.clear();
        while (!el.empty()) str.add(el.pop());

        // 将逆波兰序列求值
        Stack<Integer> stack = new Stack<>();
        n = str.size();
        for (int i = n - 1; i >= 0; i--) {
            String ss = str.get(i);
            if (ss.length() > 1 || Character.isDigit(ss.charAt(0))) {
                stack.push(Integer.parseInt(ss));
            } else {
                int r = stack.pop(); int l = stack.pop();
                if (ss.equals("+")) {
                    stack.push(l + r);
                } else if (ss.equals("-")) {
                    stack.push(l - r);
                } else if (ss.equals("*")) {
                    stack.push(l * r);
                } else {
                    stack.push(l / r);
                }
            }
        }
        return stack.pop();
    }

    public boolean check(String s1, String s2) { // 判断优先级
        if ((s2.equals("(") || s2.equals(")")) || (s1.equals("*") || s1.equals("/")) && (s2.equals("+") || s2.equals("-"))) return true;
        return false;
    }
}