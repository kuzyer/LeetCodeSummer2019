import java.util.Stack;

//前序遍历的特点： 根左右，即根节点在前面
//Tree层次遍历：0123456789，前序遍历：01378490256
public class test001 {
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

//        preOrderRe(node[0]);
        preOrder(node[0]);
    }

    //递归实现
    public static void preOrderRe(TreeNode biTree) {
        System.out.println(biTree.val);
        TreeNode leftTree = biTree.left;
        if (leftTree != null) {
            preOrderRe(leftTree);
        }
        TreeNode rightTree = biTree.right;
        if (rightTree != null) {
            preOrderRe(rightTree);
        }
    }

    //非递归实现
    public static void preOrder(TreeNode biTree) {

        Stack<TreeNode> strack = new Stack<TreeNode>();
        while (biTree != null || !strack.isEmpty()) {
            while (biTree != null) {
                System.out.println(biTree.val);
                strack.push(biTree);
                biTree = biTree.left;
            }
            if (!strack.isEmpty()) {
                biTree = strack.pop();
                biTree = biTree.right;
            }
        }
    }
}

