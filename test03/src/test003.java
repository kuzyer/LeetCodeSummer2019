import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//树专题-LeetCode94.二叉树的中序遍历
public class test003 {
//    //递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorderTraversalHelper(root, res);
//        return res;
//    }
//
//    public void inorderTraversalHelper(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            if (root.left != null) {
//                inorderTraversalHelper(root.left, res);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                inorderTraversalHelper(root.right, res);
//            }
//        }
//    }

    //栈，非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;

        }
        return res;
    }
}
