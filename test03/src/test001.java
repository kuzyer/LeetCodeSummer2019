//树专题-LeetCode98.验证二叉搜索树
public class test001 {
    public boolean isValidBST(TreeNode root) {
        return isValidTree(root, null, null);
    }

    public boolean isValidTree(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValidTree(root.left, min, root.val) && isValidTree(root.right, root.val, max);
    }
}
