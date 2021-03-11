class Solution {
private:
    stack<int> nums;
    stack<char> ops;
    map<char, int> priority;

public:
    int calculate(string s) {
        initialize_priority();
        s = regex_replace(s, regex(" "), "");
        s = regex_replace(s, regex("\\(-"), "(0-");
        nums.push(0);
        int i = 0;
        while (i < s.size()) {
            if (s[i] == ')') {
                while (!ops.empty()) {
                    if (ops.top() == '(') {
                        ops.pop();
                        break;
                    }
                    calc();
                }
                i++;
            } else if (s[i] == '(') {
                ops.push(s[i]);
                i++;
            } else {
                if (is_digit(s[i])) {
                    int num = 0;
                    while (is_digit(s[i])) {
                        num = num * 10 + (s[i] - '0');
                        i++;
                    }
                    nums.push(num);
                } else {
                    while (!ops.empty() && ops.top() != '(') {
                        if (priority[ops.top()] >= priority[s[i]]) {
                            calc();
                        } else {
                            break;
                        }
                    }
                    ops.push(s[i]);
                    i++;
                }
            }
        }
        while (!ops.empty()) {
            calc();
        }
        return nums.top();
    }

    void calc() {
        if (nums.size() < 2 || ops.empty()) {
            return ;
        }
        int num1 = nums.top(); nums.pop();
        int num2 = nums.top(); nums.pop();
        char op = ops.top(); ops.pop();
        int ans = 0;
        switch (op) {
            case '+':
                ans = num2 + num1;
                break;
            case '-':
                ans = num2 - num1;
                break;
            case '*':
                ans = num2 * num1;
                break;
            case '/':
                ans = num2 / num1;
                break;
            case '%':
                ans = num2 % num1;
                break;
            case '^':
                ans = pow(num2, num1);
        }
        nums.push(ans);
    }

    bool is_digit(char c) {
        return '0' <= c && c <= '9';
    }

    void initialize_priority() {
        priority['-'] = 1;
        priority['+'] = 1;
        priority['*'] = 2;
        priority['/'] = 2;
        priority['%'] = 2;
        priority['^'] = 3;
    }
};