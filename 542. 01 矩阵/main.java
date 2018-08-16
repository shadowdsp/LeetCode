class Solution {
    
    class Node {
        int x, y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[n][m];
        int inf = 0x3f3f3f3f;
        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0; 
                    que.offer(new Node(i, j));
                } else {
                    ans[i][j] = inf;
                }
            }
        }
        int[] x = new int[]{0, 0, 1, -1};
        int[] y = new int[]{1, -1, 0, 0};
        while (!que.isEmpty()) {
            Node now = que.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now.x + x[k], ny = now.y + y[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (ans[nx][ny] == inf) {
                        ans[nx][ny] = Math.min(ans[nx][ny], ans[now.x][now.y] + 1);
                        que.offer(new Node(nx, ny));
                    }
                }
            }
        }
        return ans;
    }
}