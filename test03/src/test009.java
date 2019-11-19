//树专题-LeetCode124.二叉树中的最大路径和
public class test009 {
    //dfs
    public int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        ans = Math.max(ans, left + root.val + right);
        return root.val + Math.max(left, right);
    }
}
