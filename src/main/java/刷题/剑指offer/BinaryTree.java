package 刷题.剑指offer;

public class BinaryTree {
    //二叉树的深度
    public static int deep(TreeNode root) {
        int deep = 0;
        if (root == null) {
            return 0;
        } else {
            int left = deep(root.left);
            int right = deep(root.right);
            deep = (left > right) ? left : right;
        }
        return deep + 1;
    }
    // 是否是平衡二叉树
    public static boolean isBalanceBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(deep(root.left) - deep(root.right)) <= 1;
        }
    }
}
