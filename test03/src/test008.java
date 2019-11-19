//树专题-LeetCode543.二叉树的直径
public class test008 {
    //dfs
    public int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int d1 = depth(root.left);
        int d2 = depth(root.right);
        ans = Math.max(ans, d1 + d2 + 1);
        return Math.max(d1, d2) + 1;
    }
}
