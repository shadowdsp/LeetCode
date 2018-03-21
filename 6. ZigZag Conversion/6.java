class Solution {
    public String convert(String s, int numRows) {
         if (numRows == 1) return s;
         StringBuilder sb = new StringBuilder();
         int n = s.length();
         for (int i = 0; i < numRows; i++) {
             int flag = 0;
             for (int j = i; j < n; ) {
                 sb.append(s.charAt(j));
                 if (flag == 0) {
                     if (numRows - i - 1 == 0) {
                         j += i * 2;
                     } else {
                         j += (numRows - i - 1) * 2 ;
                     }
                 } else {
                     if (i == 0) {
                         j += (numRows - i - 1) * 2 ;
                     } else {
                         j += i * 2;
                     }
                 }
                 flag ^= 1;
             }
         }
         return sb.toString();
     }
 }