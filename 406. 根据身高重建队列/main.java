class Solution {
    class P {
        int a, b;

        public P(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        List<P> ans = new LinkedList<>();
        int[][] res = new int[n][2];
        if (n <= 0) return res;
        int m = people[0].length;
        if (m <= 0) return res;
        P[] peo = new P[n];
        for (int i = 0; i < n; i++)
            peo[i] = new P(people[i][0], people[i][1]);
        Arrays.sort(peo, (o1, o2) -> {
            if (o1.a == o2.a) return o1.b - o2.b;
            return o2.a - o1.a;
        });
        for (P p : peo) {
            ans.add(p.b, p);
        }
        int index = 0;
        for (P p : ans) {
            res[index][0] = p.a;
            res[index++][1] = p.b;
        }
        return res;
    }
}