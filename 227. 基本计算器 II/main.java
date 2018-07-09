class Solution {
    public int calculate(String s) {
        int n = s.length();
        List<String> l1 = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
            } else if (Character.isDigit(c)) {
                num.append(c);
                flag = true;
            } else {
                if (flag) {
                    l1.add(String.valueOf(num));
                    num = new StringBuilder();
                    flag = false;
                }
                l1.add(String.valueOf(c));
            }
        }
        if (!num.toString().equals("")) l1.add(num.toString());
        Stack<String> el = new Stack<>();
        Stack<String> op = new Stack<>();
        for (String ss : l1) {
            if (Character.isDigit(ss.charAt(0))) {
                el.push(ss);
            } else {
                if (op.isEmpty()) {
                    op.push(ss);
                } else {
                    while (!op.isEmpty() && !check(op.peek(), ss))
                        el.push(op.pop());
                    op.push(ss);
                }
            }
        }
        while (!op.isEmpty()) el.push(op.pop());
        l1.clear();
        while (!el.isEmpty()) l1.add(el.pop());
        Stack<Integer> stack = new Stack<>();
        n = l1.size();
        for (int i = n - 1; i >= 0; i--) {
            String ss = l1.get(i);
            if (Character.isDigit(ss.charAt(0))) {
                stack.push(Integer.valueOf(ss));
            } else {
                int r = stack.pop(), l = stack.pop();
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

    boolean check(String a, String b) {
        return (a.equals("+") || a.equals("-")) && (b.equals("*") || b.equals("/"));
    }
}