import java.util.*;

public class Main {

    public static void order(String[] a) {
        Stack<String> stack = new Stack<>();
        stack.push(a[0]);
        while (!stack.isEmpty()) {
            
        }
    }
    
    public static String[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            return in.nextLine().split(" ");
        }
        return null;
    }

    public static void main(String[] args) {
        String[] a = parseSampleInput();
        order(a);
    }
}
