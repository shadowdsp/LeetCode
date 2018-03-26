class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxLeft = 0, maxRight = 0, ans = 0;
        while (l <= r) {
            // 可以想象一下只有被左右高的包围了，才会蓄水
            if (height[l] <= height[r]) {
                if (maxLeft < height[l]) maxLeft = height[l];
                else ans += maxLeft - height[l];
                l++;
            } else {
                if (maxRight < height[r]) maxRight = height[r];
                else ans += maxRight - height[r];
                r--;
            }
        }
        return ans;
    }
}