class Solution {
    public int maxProfit(int[] prices) {
        int mi = 0x3f3f3f3f, n = prices.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (mi > prices[i]) mi = prices[i];
            if (prices[i] - mi > ans) ans = prices[i] - mi;
        }
        return ans;
    }
}