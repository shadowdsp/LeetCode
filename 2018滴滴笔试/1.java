import java.util.*;

public class Main {

    static class P {
        char[] val;
        int score;
        int id;

        P (String val, int id) {
            this.val = val.toCharArray();
            this.score = 0;
            this.id = id;
        }
    }

    static int check(char a, char b) {
        String x = "qwertasdfgzxcv";
        int u = x.indexOf(a), v = x.indexOf(b);
        if (u != -1 && v != -1 || u == -1 && v == -1) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        ArrayList<P> list = new ArrayList<>();
        for (int i = 1; i < str.length; i++) {
            list.add(new P(str[i].toLowerCase(), i));
        }

        str[0] = str[0].toLowerCase();
        int m = str[0].length();
        int inf = 0x3f3f3f3f;

        for (int k = 0; k < list.size(); k++) {
            int n = list.get(k).val.length;
            int[][] dp = new int[m+1][n+1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[i][j] = inf;
                }
            }

            for (int i = 0; i <= m; i++) dp[i][0] = i * 3;
            for (int j = 0; j <= n; j++) dp[0][j] = j * 3;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    char a = str[0].charAt(i - 1), b = list.get(k).val[j-1];
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 3, dp[i][j-1] + 3),
                            dp[i-1][j-1] + (a == b ? 0 : check(a, b)));
                }
            }
            list.get(k).score = dp[m][n];
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.score == o2.score) {
                if (o1.id < o2.id) {
                    return -1;
                } else if (o1.id == o2.id) {
                    return 0;
                } else {
                    return 1;
                }
            }
            return o1.score < o2.score ? -1 : 1;
        });
        int up = Math.min(3, list.size());
        for (int i = 0; i < up; i++) {
            System.out.print(String.valueOf(list.get(i).val) + (up == i + 1 ? "\n" : " "));
        }
    }
}
