
class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        StringBuilder sb = new StringBuilder();
        String[] s = path.split("/");
        int ignore = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if ("".equals(s[i]) || ".".equals(s[i])) {
                ;
            } else if ("..".equals(s[i])) {
                ignore++;
            } else {
                if (ignore > 0) {
                    ignore--;
                } else {
                    sb.append(new StringBuilder(s[i]).reverse().toString() + "/");
                }
            }
        }
        if ("".equals(sb.toString())) {
            return "/";
        } else {
            return sb.reverse().toString();
        }
    }
}