class Solution {
public:
    bool isValidSerialization(string preorder) {
        int diff = 1;
        int i = 0;
        int n = preorder.size();
        while (i < n) {
            if (diff <= 0) {
                return false;
            }
            if (preorder[i] == ',') {
                i++;
            } else if (preorder[i] == '#') {
                i++;
                diff -= 1;
            } else {
                while (i < n && preorder[i] != ',') {
                    i++;
                }
                diff = diff - 1 + 2; // indeg - 1, outdeg + 2
            }
        }
        return diff == 0;
    }
};