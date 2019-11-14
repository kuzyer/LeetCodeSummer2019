//树专题-LeetCode105.从前序与中序遍历序列构造二叉树
public class test004 {
    //递归
//    中序遍历的特点： 左根右，既根节点的左右两侧分别是其左子树，右子树
//    前序遍历的特点： 根左右，既根节点在前面
//
//    具体步骤如下：
//    1. 先利用前序遍历找根节点 ( 根节点在前序遍历的前面 );
//    2. 在中序遍历中找到根节点的位置mid ( 则mid左边是左子树，右边是右子树 )；
//    3. 得到左右子树的范围后，我们先递归创建出左右子树，然后再创建根节点；
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {
        if (preLow > preHigh || inLow > inHigh) return null;
        TreeNode root = new TreeNode(preorder[preLow]);

        int inorderRoot = inLow;
        for (int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == root.val) {
                inorderRoot = i;
                break;
            }
        }
        //左子树长度
        int leftTreeLen = inorderRoot - inLow;
        //左子树
        root.left = build(preorder, preLow + 1, preLow + leftTreeLen, inorder, inLow, inorderRoot - 1);
        //右子树
        root.right = build(preorder, preLow + leftTreeLen + 1, preHigh, inorder, inorderRoot + 1, preHigh);

        return root;
    }
}
