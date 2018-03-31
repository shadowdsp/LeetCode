class Solution {
    // 记录一个前缀和一个后缀O(n)扫
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] pre = new int[n+1];
        int[] suf = new int[n+1];
        int inf = 0x3f3f3f3f;
        int mi = prices[0];
        pre[0] = 0;
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(prices[i] - mi, pre[i-1]);
            if (mi > prices[i]) mi = prices[i];
        }
        
        int ma = prices[n-1];
        suf[n-1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(ma - prices[i], suf[i+1]);
            if (ma < prices[i]) ma = prices[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) 
            if (suf[i] + pre[i] > ans) ans = suf[i] + pre[i];
        
        return ans;
    }
}