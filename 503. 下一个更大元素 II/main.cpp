// 维护单调递减栈，遍历所有元素，如果栈顶元素小于当前元素，那么栈顶元素的下一个最大值就是当前元素（单调递减的特性）
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> ret(n, -1);
        stack<int> st;
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!st.empty() && nums[st.top()] < nums[i%n]) {
                ret[st.top()] = nums[i%n];
                st.pop();
            }
            st.push(i % n);
        }
        return ret;
    }
};