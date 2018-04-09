package 刷题.剑指offer;

import java.util.Stack;

/**
 * 题目描述
 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class 二叉搜索树与双向链表 {

    /**
     * 中序遍历，
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }

        TreeNode node = pRootOfTree, pre = null;
        boolean first = true;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (first) {
                pRootOfTree = node;
                pre = pRootOfTree;
                first = false;
            } else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            node = node.right;
        }
        return pRootOfTree;
    }
}
