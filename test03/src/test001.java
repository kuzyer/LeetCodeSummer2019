import java.util.Stack;

//树专题-LeetCode98.验证二叉搜索树
public class test001 {
//    //递归 DFS
//    public boolean isValidBST(TreeNode root) {
//        return isValidTree(root, null, null);
//    }
//
//    public boolean isValidTree(TreeNode root, Integer min, Integer max) {
//        if (root == null) return true;
//        if (min != null && root.val <= min) return false;
//        if (max != null && root.val >= max) return false;
//
//        return isValidTree(root.left, min, root.val) && isValidTree(root.right, root.val, max);
//    }

    //迭代 BFS
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

}
