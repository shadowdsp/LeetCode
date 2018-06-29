class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] s = str.split(" ");
        int n = pattern.length();
        int m = s.length;
        if (n != m) return false;
        for (int i = 0; i < m; i++) {
            String now = map1.get(pattern.charAt(i));
            Character c = map2.get(s[i]);
            if (now == null && c == null) {
                map1.put(pattern.charAt(i), s[i]);
                map2.put(s[i], pattern.charAt(i));
            } else if (now == null || !now.equals(s[i]) || c == null || c.charValue() != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}