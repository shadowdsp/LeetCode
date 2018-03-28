/*
牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。 
输入描述:
每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。


输出描述:
输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。

输入例子1:
3
LRR

输出例子1:
E
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String s = scan.nextLine();
        int now = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'L') now = (now - 1 + 4) % 4;
            else now = (now + 1) % 4;
        }
        char ss = 'N';
        if (now == 1) ss = 'E';
        else if (now == 2) ss = 'S';
        else if (now == 3) ss = 'W';
        System.out.println(ss);
    }
}