import java.util.Stack;

//树专题-LeetCode101.对称二叉树
public class test002 {
//    //递归 DFS
//    public boolean isSymmetric(TreeNode root) {
//        return root == null || isSymmetricHelp(root.left, root.right);
//    }
//
//    public boolean isSymmetricHelp(TreeNode left, TreeNode right){
//        if (left == null && right == null) return true;
//        if (left == null || right == null) return false;
//        if (left.val != right.val) return false;
//        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
//    }

    //迭代 BFS
    //用栈模拟递归，对根节点的左子树，我们用中序遍历；对根节点的右子树，我们用反中序遍历。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode lc = root.left;
        TreeNode rc = root.right;
        while (lc != null || rc != null || !left.isEmpty() || !right.isEmpty()) {
            while (lc != null && rc != null) {
                left.push(lc);
                right.push(rc);
                lc = lc.left;
                rc = rc.right;
            }
            //lc,rc如果都为空才有镜像的可能，如果其中一个不为空，则说明不是镜像
            if (lc != null || rc != null) return false;
            lc = left.pop();
            rc = right.pop();
            if (lc.val != rc.val) return false;
            lc = lc.right;
            rc = rc.left;
        }
        return true;
    }

}
