class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        int cnt = 0, pre = 1, i = 0;
        while (cnt < num) {
            for (i = 0; i < pre && cnt < num; i++, cnt++) 
                ans[i+pre] = ans[i] + 1;
            pre += i;
        }
        return ans;
    }
}