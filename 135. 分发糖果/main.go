class Solution {
    public int candy(int[] ratings) {
        Queue<Integer> que = new LinkedList<>();
        int n = ratings.length;
        if (n == 1) return 1;
        boolean []vis = new boolean[n];
        int []res = new int[n];
        for (int i = 0; i < n; i++) vis[i] = false;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (ratings[i] <= ratings[i+1]) {
                    vis[i] = true;
                    res[i] = 1;
                    que.offer(i);
                }
            } else if (i == n - 1) {
                if (ratings[i] <= ratings[i-1]) {
                    vis[i] = true;
                    res[i] = 1;
                    que.offer(i);
                }
            } else {
                if (ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]) {
                    vis[i] = true;
                    res[i] = 1;
                    que.offer(i);
                }
            }
        }
        while (!que.isEmpty()) {
            int u = que.poll();
            int i = u - 1;
            if (0 <= i && !vis[i]) {
                if (i == 0 || ratings[i] > ratings[u] && res[i] <= res[u]) {
                    if (i == 0) vis[i] = true;
                    res[i] = res[u] + 1;
                    que.offer(i);
                }
            }
            i = u + 1;
            if (i < n && !vis[i]) {
                if (i == n - 1 || ratings[i] > ratings[u] && res[i] <= res[u]) {
                    if (i == n - 1) vis[i] = true;
                    res[i] = res[u] + 1;
                    que.offer(i);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) ans += res[i];
        return ans;
    }
}