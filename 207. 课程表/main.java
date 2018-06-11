class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> que = new LinkedList<>();
        int n = prerequisites.length;
        if (n <= 0) return true;
        int m = prerequisites[0].length;
        if (m <= 0) return true;
        int[] deg = new int[numCourses];
        for (int i = 0; i < n; i++) {
            int u = prerequisites[i][0], v = prerequisites[i][1];
            deg[v]++;
        }
        int ans = 0;
        for (int i = 0; i < numCourses; i++) {
            if (deg[i] <= 0) {
                que.offer(i);
                ans++;
            }
        }
        while (!que.isEmpty()) {
            int u = que.poll();
            for (int i = 0; i < n; i++) {
                if (prerequisites[i][0] == u) {
                    deg[prerequisites[i][1]]--;
                    if (deg[prerequisites[i][1]] <= 0) {
                        que.offer(prerequisites[i][1]);
                        ans++;
                    }
                }
            }
        }
        return ans == numCourses;
    }
}