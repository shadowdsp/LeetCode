/*
平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。

如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。

请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。


输入描述:
输入包括五行。
第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。


输出描述:
输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。

输入例子1:
2
0 90
0 90
100 200
100 200

输出例子1:
2
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        int[] y1 = new int[n];
        int[] y2 = new int[n];
        List<Integer> xx = new ArrayList<>();
        List<Integer> yy = new ArrayList<>();
        for (int i = 0; i < n; i++) { x1[i] = scan.nextInt(); xx.add(x1[i]); }
        for (int i = 0; i < n; i++) { y1[i] = scan.nextInt(); yy.add(y1[i]); }
        for (int i = 0; i < n; i++) { x2[i] = scan.nextInt(); xx.add(x2[i]); }
        for (int i = 0; i < n; i++) { y2[i] = scan.nextInt(); yy.add(y2[i]); }
        int ans = 1;
        for (int x : xx) {
            for (int y : yy) {
                int now = 0;
                for (int i = 0; i < n; i++) {
                    if (x1[i] <= x && x < x2[i] && y1[i] <= y && y < y2[i]) now++;
                }
                if (now > ans) ans = now;
            }
        }
        System.out.println(ans);
    }
}