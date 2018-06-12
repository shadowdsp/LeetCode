class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> que = new LinkedList<>();
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) res[i] = i;
        int n = prerequisites.length;
        if (n <= 0) return res;
        int m = prerequisites[0].length;
        if (m <= 0) return res;
        int[] deg = new int[numCourses];
        for (int i = 0; i < n; i++) {
            int u = prerequisites[i][0], v = prerequisites[i][1];
            deg[u]++;
        }
        int ans = 0;
        for (int i = 0; i < numCourses; i++) {
            if (deg[i] <= 0) {
                que.offer(i);
            }
        }
        while (!que.isEmpty()) {
            int u = que.poll();
            res[ans++] = u;
            for (int i = 0; i < n; i++) {
                if (prerequisites[i][1] == u) {
                    deg[prerequisites[i][0]]--;
                    if (deg[prerequisites[i][0]] <= 0) {
                        que.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return ans == numCourses ? res : new int[0];
    }
}