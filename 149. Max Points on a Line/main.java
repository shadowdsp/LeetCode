// 使用hashmap保存（x,y）二维组，并取最大，注意共点。
class Solution {
    public int maxPoints(Point[] points) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            map.clear();
            int same = 0;
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int difx = points[j].x - points[i].x;
                int dify = points[j].y - points[i].y;
                if (difx == 0 && dify == 0) {
                    same++;
                    continue;
                }
                int d = gcd(difx, dify);
                if (d != 0) {
                    difx /= d;
                    dify /= d;
                }
                if (map.containsKey(difx)) {
                    if (map.get(difx).containsKey(dify)) {
                        map.get(difx).put(dify, map.get(difx).get(dify) + 1);
                    } else {
                        map.get(difx).put(dify, 1);
                    }
                } else {
                    HashMap<Integer, Integer> mm = new HashMap<>();
                    mm.put(dify, 1);
                    map.put(difx, mm);
                }
                max = Math.max(max, map.get(difx).get(dify));
            }
            ans = Math.max(ans, same + max + 1);
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}