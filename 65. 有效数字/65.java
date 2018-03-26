class Solution {
    public boolean isNumber(String s) {
        char[] str = s.trim().toCharArray(); // 去掉前后空格
        int n = str.length;
        if (n <= 0) return false;
        int id = 0;
        if (str[id] == '-' || str[id] == '+') id++;
        boolean point = false, exp = false, num = false; // 分别表示出现过小数点，指数和数字
        while (id < n) {
            if (str[id] == 'E' || str[id] == 'e') {
                if (exp) return false; // 出现多次
                if (!(id > 0 && (('0' <= str[id-1] && str[id-1] <= '9') || str[id-1] == '.' && num))) return false; // 指数前面不是数字并且不是'.' (".e1"这种数据输出false,"1.e1"这种数据输出true)
                if (id == n - 1) return false; // 如果是最后一位就不行
                exp = true;
            } else if (str[id] == '-' || str[id] == '+') {
                if (!(id > 0 && (str[id-1] == 'e' || str[id-1] == 'E')))  return false; // 符号前面不是指数
                if (id == n - 1) return false; // 如果是最后一位就不行
            } else if (str[id] == '.') {
                if (point) return false; // 出现多次
                if (exp) return false; // 指数后面不能跟小数点
                point = true;
            } else if (!('0' <= str[id] && str[id] <= '9')) {
                return false; // 不是数字就不行
            } else if ('0' <= str[id] && str[id] <= '9') {
                num = true;
            }
            id++;
        }
        return num;
    }
}