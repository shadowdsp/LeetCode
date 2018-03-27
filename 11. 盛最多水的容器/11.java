class Solution {
    public int maxArea(int[] height) {
        // 类似于接雨水
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int now = Math.min(height[l], height[r]) * (r - l);
            if (now > ans) ans = now;
            if (height[l] > height[r]) r--;
            else l++;
        }
        return ans;
    }
}