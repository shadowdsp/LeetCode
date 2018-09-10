import java.util.*;

public class Main {

    private static int len(String s) {
        return s.length();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        Arrays.sort(s, (o1, o2) -> {
            int n = o1.length(), m = o2.length();
            int mi = Math.min(n, m);
            int i = 0;
            while (i < mi) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o1.charAt(i) < o2.charAt(i) ? -1 : 1;
                }
                i++;
            }
            if (n == m) {
                return 0;
            } else if (n == mi) {
                return -1;
            }
            return 1;
        });
        int n = s.length;
        String[] str = new String[n];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (!s[i].equals(s[i-1])) {
                str[cnt++] = s[i-1];
            }
        }
        if (n > 1 && !s[n-1].equals(s[n-2])) {
            str[cnt++] = s[n-1];
        }
        n = cnt;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int l = len(str[i]);
            if (l % 2 != 0) {
                continue;
            }
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                int r = len(str[j]);
                if (vis[j] && r + 2 == l && str[j].equals(str[i].substring(0, r))) {
                    flag = true;
                    break;
                }
            }
            if (flag || l == 2) {
                vis[i] = true;
                for (int j = 0; j < l / 2 - 1; j++) {
                    System.out.print("    ");
                }
                System.out.println(str[i]);
            }
        }
    }

}
