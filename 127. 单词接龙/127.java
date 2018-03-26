import java.util.*;

class Solution {
    class Edge {
        int u, v, nxt;

        public Edge(int u, int v, int nxt) {
            this.u = u; this.v = v; this.nxt = nxt;
        }
    }

    class Node {
        // 距离和结点
        int d, v;

        public Node(int d, int v) {
            this.d = d; this.v = v;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int st = -1, ed = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) st = i;
            if (wordList.get(i).equals(endWord)) ed = i;
        }
        int n = wordList.size();
        if (ed == -1) return 0;
        if (st == -1) { wordList.add(beginWord); n = wordList.size(); st = n - 1; }

        // Build graph 邻接链表
        List<Edge> edge = new ArrayList<>();
        int[] head = new int[n];
        int tot = 0;
        Arrays.fill(head, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(wordList.get(i), wordList.get(j))) {
                    edge.add(new Edge(i, j, head[i])); head[i] = tot++;
                    edge.add(new Edge(j, i, head[j])); head[j] = tot++;
                }
            }
        }

        return dijkstra(st, ed, n, edge, head);
    }

    // 堆优化Dijkstra，普通的O(n^2)过不去
    int dijkstra(int st, int ed, int n, List<Edge> edge, int[] head) {
        PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.d != o2.d) return o1.d - o2.d;
                return o1.v - o2.v;
            }
        });
        int[] dis = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dis, 0x3f3f3f3f);
        dis[st] = 1; vis[st] = true;
        que.offer(new Node(1, st));
        while (!que.isEmpty()) {
            Node now = que.poll();
            int u = now.v; int d = now.d;
            for (int i = head[u]; i != -1; i = edge.get(i).nxt) {
                int v = edge.get(i).v;
                if (1 + d < dis[v]) {
                    dis[v] = 1 + d;
                    if (!vis[v]) {
                        vis[v] = true;
                        que.offer(new Node(dis[v], v));
                    }
                }
            }
        }
        return dis[ed] == 0x3f3f3f3f ? 0 : dis[ed];
    }

    // 如果只有一个位置不同，那么可以连边
    boolean check(String a, String b) {
        int n = a.length();
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (a.charAt(i) != b.charAt(i)) cnt++;
        return cnt == 1;
    }
}