package 数据结构.binarytree;

import java.util.PriorityQueue;
import java.util.Stack;

class BNode{
    private Object data;
    private BNode left;
    private BNode right;
    private BNode parent;
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BNode getParent() {
        return parent;
    }

    public void setParent(BNode parent) {
        this.parent = parent;
    }

    public BNode getLeft() {
        return left;
    }
    public void setLeft(BNode left) {
        this.left = left;
    }
    public BNode getRight() {
        return right;
    }
    public void setRight(BNode right) {
        this.right = right;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public BNode() {
        // TODO Auto-generated constructor stub
        this.data = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = -1;
    }
    public BNode(Object data) {
        // TODO Auto-generated constructor stub
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
    }
}

public class BalancedBinaryTree {

    private BNode root = null;

    public BalancedBinaryTree() {
        // TODO Auto-generated constructor stub
        this.root = null;
    }
    //创建二叉树
    /**
     *          A
     *       B			C
     *  D		  E   		 F
     */
/*    public void create() {
        this.root = new BNode("A");
        BNode BNodeA = new BNode("B");
        BNode BNodeB = new BNode("C");
        BNode BNodeC = new BNode("D");
        BNode BNodeD = new BNode("E");
        BNode BNodeE = new BNode("F");
        this.root.setLeft(BNodeA);
        this.root.setRight(BNodeB);
        BNodeA.setLeft(BNodeC);
        BNodeA.setRight(BNodeD);
        BNodeB.setRight(BNodeE);
    }*/
    public BNode getRoot() {
        return root;
    }
    //是否为空
    public boolean isEmpty() {
        return this.root == null;
    }
    //遍历二叉树
    //先序遍历,先访问根节点，在访问左节点，后访问右节点
    public void firstOrder(BNode root) {
        if(root != null) {
            System.out.println(root.getData());
            firstOrder(root.getLeft());
            firstOrder(root.getRight());
        }
    }
    //先序遍历,非递归实现,先访问根节点，在访问左节点，后访问右节点
    public void firstOrderNoRecursion(BNode root) {
        Stack<BNode> stack = new Stack<>();
        BNode temp = root;
        while(temp != null || stack.size() > 0) {
            while(temp != null) {
                System.out.println(temp.getData());
                stack.push(temp);
                temp = temp.getLeft();
            }
            temp = stack.pop();
            temp = temp.getRight();
        }
    }
    //后序遍历，先访问左节点，在访问根节点，后访问右节点
    public void lastOrder(BNode root) {
        if(root != null) {
            lastOrder(root.getLeft());
            lastOrder(root.getRight());
            System.out.println(root.getData());
        }
    }
    //非递归后序遍历，先访问左节点，在访问根节点，后访问右节点
    public void lastOrderNoRecursion(BNode root) {
        Stack<BNode> stack = new Stack<>();
        BNode temp = new BNode();
        while(temp != null || stack.size() > 0) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }
            temp = stack.pop();
            System.out.println(temp.getData());
            temp = temp.getRight();
        }
    }
    //中序遍历，先访问左节点，在访问右节点，后访问根节点
    public void middleOrder(BNode root) {
        if(root != null) {
            middleOrder(root.getLeft());
            System.out.println(root.getData());
            middleOrder(root.getRight());
        }
    }
    //中序遍历，先访问左节点，在访问右节点，后访问根节点
    public void middleOrderNoRecursion(BNode root) {
        Stack<BNode> stack = new Stack<>();
        BNode temp = new BNode();
        while (temp != null || stack.size() > 0) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }
            temp = stack.pop();
            temp = temp.getRight();
            if (temp != null)
                System.out.println(temp.getData());
        }
    }
    //层次遍历
    public void layerRecursion(BNode root) {
        PriorityQueue<BNode> queue = new PriorityQueue<BNode>();
        if(root == null){
            return ;
        }else {
            queue.add(root);
            while(!queue.isEmpty()) {
                BNode temp = queue.poll();
                System.out.println(temp.getData());
                if(temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if(temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
    }
    //向二叉树中添加节点
    public void insert(BNode root, Object data){
        if(root == null) {
            BNode newBNode = new BNode(data);
            root = newBNode;
            root.setParent(root);
            this.root = root;
            return;
        }else if(this.root.getData().equals(data)){
            return;
        }else if((int) this.root.getData() < (int) data){
            if(root.getLeft() != null) {
                insert(root.getLeft(), data);
            }else{
                BNode temp = new BNode(data);
                temp.setParent(root);
                root.setLeft(temp);

            }
        }
    }
    //左单旋
    public void singleLeftRotation(BNode root){
        BNode temp = root.getLeft();
        root.setLeft(temp.getRight());
        temp.setRight(root);
        int lHight = root.getLeft().getHeight();
        int rHight = root.getRight().getHeight();
        root.setHeight(lHight > rHight ? lHight : rHight + 1);
        lHight = temp.getLeft().getHeight();
        rHight = temp.getRight().getHeight();
        temp.setHeight(lHight > rHight ? lHight : rHight + 1);
        this.root = temp;
    }
    //右单旋
    public void singleRightRotation(BNode root){
        BNode temp = root.getRight();
        root.setRight(temp.getLeft());
        temp.setLeft(root);
        int hight = Math.max(root.getLeft().getHeight(), root.getRight().getHeight()) + 1;
        root.setHeight(hight);
        hight = Math.max(temp.getLeft().getHeight(), temp.getRight().getHeight()) + 1;
        temp.setHeight(hight);
        this.root = temp;
    }
    //二叉树的深度
    public static void main(String[] args) {
        System.out.println();
    }
}
