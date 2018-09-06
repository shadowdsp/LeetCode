import java.util.*;

public class Main {

    public static void encode(int[] a) {
        for (int s : a) {
            if (s == 1) {
                System.out.print("5");
            } else if (s == 2) {
                System.out.print("3");
            } else if (s == 3) {
                System.out.print("1");
            } else if (s == 4) {
                System.out.print("2");
            } else {
                System.out.print("4");
            }
        }
    }

    public static int[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String[] t1 = in.nextLine().split(" ");
            int[] t2 = new int[t1.length];
            for (int i = 0; i < t1.length; i++) {
                t2[i] = Integer.parseInt(t1[i]);
            }
            return t2;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = parseSampleInput();
        encode(a);
    }
}
