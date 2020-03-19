import java.util.LinkedList;

//Tree层次遍历：0123456789，BFS(通过队列实现)
//层次遍历的步骤是：
//    1.对于不为空的结点，先把该结点加入到队列中
//    2.从队中拿出结点，如果该结点的左右结点不为空，就分别把左右结点加入到队列中
//    3.重复以上操作直到队列为空
public class test004 {
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

        levelOrder(node[0]);
    }

    public static void levelOrder(TreeNode biTree) {
        if (biTree == null)
            return;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(biTree);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            System.out.println(currentNode.val);
            if (currentNode.left != null)
                list.add(currentNode.left);
            if (currentNode.right != null)
                list.add(currentNode.right);
        }
    }
}
