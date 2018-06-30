class Solution {
    int n;
    int[] tree;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        n = nums.length;
        if (n <= 0) return ans;
        tree = new int[n<<2];
        int[] id = new int[n];
        int[] cid = new int[n];
        for (int i = 0; i < n; i++) id[i] = nums[i];
        Arrays.sort(id);
        int cnt = 0;
        cid[cnt++] = id[0];
        for (int i = 1; i < n; i++) 
            if (id[i] != cid[cnt-1]) cid[cnt++] = id[i];
        
        for (int i = n - 1; i >= 0; i--) {
            int k = bs(0, cnt - 1, nums[i], cid) + 1;
            ans.add(query(1, 1, cnt, k - 1));
            update(1, 1, cnt, k);
        }
        Collections.reverse(ans);
        return ans;
    }
    
    int bs(int l, int r, int val, int[] id) {
        int ans = l;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (id[mid] <= val) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    
    void pushup(int rt) {
        tree[rt] = tree[rt<<1] + tree[rt<<1|1];
    }
    
    void update(int rt, int l, int r, int id) {
        if (l == r) {
            tree[rt]++;
            return ;
        }
        int mid = (l + r) >> 1;
        if (id <= mid) update(rt<<1, l, mid, id);
        else update(rt<<1|1, mid+1, r, id);
        pushup(rt);
    }
    
    int query(int rt, int l, int r, int id) {
        if (id <= 0) return 0;
        if (r <= id) return tree[rt];
        int mid = (l + r) >> 1;
        int sum = 0;
        if (id > mid) sum += query(rt<<1|1, mid + 1, r, id);
        sum += query(rt<<1, l, mid, id);
        return sum;
    }
}