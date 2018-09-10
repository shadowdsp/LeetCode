import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
        int n = nums.size();
        int[] dp = new int[n+1];
        dp[0] = 1;
        int ans = 0, id = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && (nums.get(i) - 1) == nums.get(i-1)) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            if (dp[i] > ans) {
                ans = dp[i];
                id = i - dp[i] + 1;
            }
        }
        System.out.println("[" + nums.get(id) + ", " + ans + "]");
    }

}
