import java.util.Stack;
//树专题-LeetCode173.二叉搜索树迭代器
//注意本树是二叉搜索树，因此找最小的点必然先找左子树
public class test010 {
    Stack<TreeNode> stack = new Stack<>();

    //public BSTIterator(TreeNode root)
    public test010(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        int v = cur.val;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return v;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
