import java.util.*;

public class Main {

    static class MyObject {
        int id;
        int score;
        public MyObject(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public String toString() {
            return "{" + id + ":" + score + "}";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static void sort(MyObject[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j].score > a[j+1].score) {
                    a[j].score ^= a[j+1].score;
                    a[j+1].score ^= a[j].score;
                    a[j].score ^= a[j+1].score;

                    a[j].id ^= a[j+1].id;
                    a[j+1].id ^= a[j].id;
                    a[j].id ^= a[j+1].id;
                }
            }
        }
    }

    public static MyObject[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        List<MyObject> list = new ArrayList<>();
        while (in.hasNextInt()) {
            int id = in.nextInt();
            int score = in.nextInt();
            list.add(new MyObject(id, score));
        }
        MyObject[] a = new MyObject[list.size()];
        return list.toArray(a);
    }

    public static void main(String[] args) {
        MyObject[] a = parseSampleInput();
        sort(a);
        System.out.println("Result: " + Arrays.toString(a));
    }
}
