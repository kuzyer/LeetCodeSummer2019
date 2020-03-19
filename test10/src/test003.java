import java.util.Stack;

//后序遍历的特点： 左右根
//Tree层次遍历：0123456789，后序遍历：7839415620
public class test003 {
    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10)
                node[i].left = node[i*2+1];
            if (i * 2 + 2 < 10)
                node[i].right = node[i*2+2];
        }

//        postOrderRe(node[0]);
        postOrder(node[0]);
    }

    //递归实现
    public static void postOrderRe(TreeNode biTree) {
        if (biTree == null) {
            return;
        } else {
            postOrderRe(biTree.left);
            postOrderRe(biTree.right);
            System.out.println(biTree.val);
        }
    }

    //非递归实现
    public static void postOrder(TreeNode biTree) {
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点

        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                //将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.left;
            }

            while (!stack.isEmpty() && stack2.peek() == right) {
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().val);
            }

            if (!stack.empty() && stack2.peek() == left) {
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().right;
            }

        }
    }

}
