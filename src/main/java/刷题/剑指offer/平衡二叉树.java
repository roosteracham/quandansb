package 刷题.剑指offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {

        return BinaryTree.isBalanceBinaryTree(root);
    }

    public static void main(String[] args) {
        System.out.println(test(10));
    }
    static boolean test(int a) {
        if (a < 5){

            return false;
        } else {
            return test(a - 1);
        }
    }
}
