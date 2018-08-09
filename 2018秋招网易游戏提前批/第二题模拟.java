import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        while (t > 0) {
            t--;
            String s = scan.nextLine();
            boolean ans = true;
            if (s.length() < 8) {
                ans = false;
            }
            String sp = "!@#$%^&*()_-+=[]{},.<>/?";
            boolean q = false, w = false, e = false, r = false;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if ('A' <= ch && ch <= 'Z') q = true;
                if ('a' <= ch && ch <= 'z') w = true;
                if ('0' <= ch && ch <= '9') e = true;
                for (int j = 0; j < sp.length(); j++) {
                    if (sp.charAt(j) == ch) {
                        r = true;
                    }
                }
            }
            if (!q || !w || !e || !r) {
                ans = false;
            }
            for (int i = 2; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i-2)) ||
                        !Character.isDigit(s.charAt(i-1)) ||
                        !Character.isDigit(s.charAt(i))) continue;
                int a = s.charAt(i-2) - '0';
                int b = s.charAt(i-1) - '0';
                int c = s.charAt(i) - '0';
                if (c - b == b - a) {
                    ans = false;
                }
            }
            for (int i = 2; i < s.length(); i++) {
                char a = s.charAt(i-2);
                char b = s.charAt(i-1);
                char c = s.charAt(i);
                if (Character.isUpperCase(a) && Character.isUpperCase(b) && Character.isUpperCase(c) ||
                        Character.isLowerCase(a) && Character.isLowerCase(b) && Character.isLowerCase(c)) {
                    if (a + 1 == b && b + 1 == c) {
                        ans = false;
                    }
                }
            }
            String[] ssp = {"password", "admin", "qwerty", "hello", "iloveyou", "112233"};
            for (String sdp : ssp) {
                if (s.contains(sdp)) {
                    ans = false;
                }
            }
            if (ans) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
/*
10
aaabbbcccA1#
iloveyou,admin
*OldIron666
[]<>(){}
(Hello+World)*2
A2345678910JQK
Root@163.com
cba&ZYX0
pas$w0Rd
133_Ckk

yes
no
no
no
yes
no
yes
yes
yes
no
 */