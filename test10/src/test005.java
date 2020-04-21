import java.util.Scanner;

//通过前序和中序，推出后序
public class test005 {


//    static char [] preorder;
//    static  char[] inorder;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        String[] split = line.split(",");
//        preorder = split[0].toCharArray();
//        inorder = split[1].toCharArray();
//        TreeNode root =
//
//    }
//
//    public static void resumeTree(char[] )

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder, inorder);
    }

    public static void buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return;
        TreeNode treeNode =  build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        postOrderRe(treeNode);
    }

    public static TreeNode build(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {
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
        root.right =  build(preorder,preLow + leftTreeLen + 1, preHigh, inorder, inorderRoot + 1, inHigh);

        return root;

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
}
