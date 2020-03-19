import java.util.Stack;

//中序遍历的特点： 左根右
//Tree层序遍历：0123456789，中序遍历：7381940526
public class test002 {
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

//        midOrderRe(node[0]);
        minOrder(node[0]);
    }

    //递归实现
    public static void midOrderRe(TreeNode biTree) {
        if (biTree == null) {
            return;
        } else {
            midOrderRe(biTree.left);
            System.out.println(biTree.val);
            midOrderRe(biTree.right);
        }
    }

    //非递归实现
    public static void minOrder(TreeNode biTree) {

        Stack<TreeNode> strack = new Stack<TreeNode>();
        while (biTree != null || !strack.isEmpty()) {
            while (biTree != null) {
                strack.push(biTree);
                biTree = biTree.left;
            }
            if (!strack.isEmpty()) {
                biTree = strack.pop();
                System.out.println(biTree.val);
                biTree = biTree.right;
            }
        }
    }
}
