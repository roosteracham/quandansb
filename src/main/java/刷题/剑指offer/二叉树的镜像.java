package 刷题.剑指offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 输入描述:
 二叉树的镜像定义：源二叉树
             8
           /  \
          6   10
         / \  / \
        5  7 9 11
 镜像二叉树
            8
          /  \
        10   6
        / \  / \
       11 9 7  5
 */
public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }else if (root.left == null) {
            root.left = root.right;
            root.right = null;
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
        } else {
            /*TreeNode temp = new TreeNode(root.left.val);
            temp.left = root.left.left;
            temp.right = root.left.right;
            root.left = root.right;
            root.right = temp;*/

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        Mirror(root.left);
        Mirror(root.right);
    }
}
