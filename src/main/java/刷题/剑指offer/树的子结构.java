package 刷题.剑指offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 */
public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root2 == null || root1 == null) {
            return false;
        }

        StringBuilder sb1 = new StringBuilder("");
        StringBuilder sb3 = new StringBuilder("");
        firstOrder(root1, sb1);
        middleOrder(root1, sb3);
        StringBuilder sb2 = new StringBuilder("");
        StringBuilder sb4 = new StringBuilder("");
        firstOrder(root2, sb2);
        middleOrder(root1, sb4);

        if (sb1.toString().indexOf(sb2.toString()) != -1 && sb3.toString().indexOf(sb4.toString()) != -1) {
            return true;
        }
        return false;
    }

    public void firstOrder(TreeNode root, StringBuilder stringBuilder) {
        if(root != null) {
            stringBuilder.append(root.val);
            firstOrder(root.left, stringBuilder);
            firstOrder(root.right, stringBuilder);
        }
    }
    public void middleOrder(TreeNode root, StringBuilder stringBuilder) {
        if(root != null) {
            middleOrder(root.left, stringBuilder);
            stringBuilder.append(root.val);
            middleOrder(root.right, stringBuilder);
        }
    }
}

