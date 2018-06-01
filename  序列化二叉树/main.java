/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "#,";
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        int n = str.length();
        if (index < n - 1) {
            while (str.charAt(index) == ',') index++;
            char val = str.charAt(index);
            if (val == '#') {
                return null;
            } else {
                StringBuilder num = new StringBuilder();
                while (str.charAt(index) != ',') {
                    num.append(str.charAt(index));
                    index++;
                }
                TreeNode now = new TreeNode(Integer.parseInt(num.toString()));
                now.left = Deserialize(str);
                now.right = Deserialize(str);
                return now;
            }
        }
        return null;
    }
}