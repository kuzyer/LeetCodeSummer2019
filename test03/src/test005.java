import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//树专题-LeetCode102.二叉树的层次遍历
public class test005 {

//    //递归
//    List<List<Integer>> levels = new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return levels;
//        helper(root, 0);
//        return levels;
//    }
//
//    public void helper(TreeNode node, int level) {
//        if (levels.size() == level) {
//            levels.add(new ArrayList<Integer>());
//        }
//        levels.get(level).add(node.val);
//
//        if (node.left != null) {
//            helper(node.left, level + 1);
//        }
//        if (node.right != null) {
//            helper(node.right, level + 1);
//        }
//    }


    //队列，非递归
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if (root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }

        return wrapList;
    }
}
