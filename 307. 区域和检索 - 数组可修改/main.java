class NumArray {
    int[] tree;
    int n;
    
    void pushup(int rt) {
        tree[rt] = tree[rt<<1] + tree[rt<<1|1];
    }

    void build(int rt, int l, int r, int[] nums) {
        if (l == r) {
            tree[rt] = nums[l-1];
            return ;
        } else if (r < l) {
            return ;
        }
        int m = (l + r) / 2;
        build(rt<<1, l, m, nums);
        build(rt<<1|1, m + 1, r, nums);
        pushup(rt);
    }
    
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n<<2];
        build(1, 1, n, nums);
    }
    
    void Update(int rt, int l, int r, int id, int val) {
        if (l == r) {
            tree[rt] = val;
            return ;
        }
        int m = (l + r) / 2;
        if (id <= m) Update(rt<<1, l, m, id, val);
        else Update(rt<<1|1, m + 1, r, id, val);
        pushup(rt);
    }
    
    public void update(int i, int val) {
        Update(1, 1, n, i + 1, val);
    }
    
    int Query(int rt, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return tree[rt];
        }
        int ans = 0;
        int m = (l + r) / 2;
        if (L <= m) ans += Query(rt<<1, l, m, L, R);
        if (m < R) ans += Query(rt<<1|1, m + 1, r, L, R);
        return ans;
    }
    
    public int sumRange(int i, int j) {
        return Query(1, 1, n, i + 1, j + 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */