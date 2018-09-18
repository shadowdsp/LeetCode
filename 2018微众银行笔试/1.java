import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static void GetResult(int d) {
        long n = 0;
        while ((n + 1) * n / 2 < d) {
            n++;
        }
        n--;
        long x = d - ((n + 1) * n / 2);
        if (n % 2 == 1) {
            System.out.printf("%d/%d\n", x, (n + 2) - x);
        } else {
            System.out.printf("%d/%d\n", (n + 2) - x, x);
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _N;
        _N = Integer.parseInt(in.nextLine().trim());

        GetResult(_N);
    }
}
