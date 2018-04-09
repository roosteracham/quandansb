package 刷题.剑指offer;

import java.util.ArrayList;

/**
 * 题目描述
 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        nodes.add(root);
        while (!nodes.isEmpty()) {
            root = nodes.remove(nodes.size() - 1);
            path.add(root.val);
            if (root.left != null) {
                nodes.add(0, root.left);
            }
            if (root.right != null) {
                nodes.add(0, root.right);
            }
            if (root.right == null && root.left == null) {
                int sum = 0;
                for (int i = 0; i < path.size(); i++) {
                    sum += path.get(i);
                }
                if (sum == target) {
                    lists.add(path);

                }
                path.remove(path.size() - 1);
            }
        }
        return lists;
    }

/*
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return res;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return res;
    }*/
}
