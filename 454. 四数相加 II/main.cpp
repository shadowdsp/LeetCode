class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        int n1 = A.size(), n2 = B.size(), n3 = C.size(), n4 = D.size();
        vector<int> sum;
        for (int i = 0; i < n3; i++) {
            for (int j = 0; j < n4; j++) {
                sum.push_back(C[i] + D[j]);
            }
        }
        sort(sum.begin(), sum.end());
        int ans = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int r = upper_bound(sum.begin(), sum.end(), -A[i] - B[j]) - sum.begin();
                int l = lower_bound(sum.begin(), sum.end(), -A[i] - B[j]) - sum.begin();
                ans += max(0, r - l);
            }
        }
        return ans;
    }
};