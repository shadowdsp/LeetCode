class Solution {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }

    boolean match(String s, int sid, String p, int pid) {
        int n = s.length(), m = p.length();
//        System.out.println(sid + " - " + pid);
        if (sid == n && pid == m) return true;
        if (sid < n && pid == m) return false;
        if (pid < m - 1 && p.charAt(pid + 1) == '*') {
            if (sid < n && (s.charAt(sid) == p.charAt(pid) || p.charAt(pid) == '.')) { // 匹配的话可以选择使用*或者不使用
                return match(s, sid, p, pid + 2) || match(s, sid + 1, p, pid);
            } else { // 不匹配只能使用掉*去抵消掉
                return match(s, sid, p, pid + 2);
            }
        } else if (sid < n && (s.charAt(sid) == p.charAt(pid) || p.charAt(pid) == '.')) { // 没有*就只能匹配了
            return match(s, sid + 1, p, pid + 1);
        }
        return false;
    }
}