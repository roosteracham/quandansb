package 数据结构.binarytree;

import java.util.PriorityQueue;
import java.util.Stack;

public class BinaryTree {

    private Node root = null;
    public BinaryTree() {
        // TODO Auto-generated constructor stub
        this.root = null;
    }
    //创建二叉树
    /**
     *          A
     *       B			C
     *  D		  E   		 F
     */
    public void create() {
        this.root = new Node("A");
        Node nodeA = new Node("B");
        Node nodeB = new Node("C");
        Node nodeC = new Node("D");
        Node nodeD = new Node("E");
        Node nodeE = new Node("F");
        this.root.setLeft(nodeA);
        this.root.setRight(nodeB);
        nodeA.setLeft(nodeC);
        nodeA.setRight(nodeD);
        nodeB.setRight(nodeE);
    }
    public Node getRoot() {
        return root;
    }
    //是否为空
    public boolean isEmpty() {
        return this.root == null;
    }
    //遍历二叉树
    //先序遍历,先访问根节点，在访问左节点，后访问右节点
    public void firstOrder(Node root) {
        if(root != null) {
            System.out.println(root.getData());
            firstOrder(root.getLeft());
            firstOrder(root.getRight());
        }
    }
    //先序遍历,非递归实现,先访问根节点，在访问左节点，后访问右节点
    public void firstOrderNoRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        Node temp = root;
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
    public void lastOrder(Node root) {
        if(root != null) {
            lastOrder(root.getLeft());
            lastOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    //非递归后序遍历，先访问左节点，在访问根节点，后访问右节点
    public void lastOrderNoRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        Node temp = new Node();
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
    public void middleOrder(Node root) {
        if(root != null) {
            middleOrder(root.getLeft());
            System.out.println(root.getData());
            middleOrder(root.getRight());
        }
    }
    //中序遍历，先访问左节点，在访问右节点，后访问根节点
    public void middleOrderNoRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        Node temp = new Node();
        while(temp != null || stack.size() > 0) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }
            temp = stack.pop();
            temp = temp.getRight();
            if(temp != null) {
                System.out.println(temp.getData());
            }
        }
    }

    public void layerRecursion(Node root) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        if(root == null){
            return ;
        }else {
            queue.add(root);
            while(!queue.isEmpty()) {
                Node temp = queue.poll();
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

    //二叉树的深度
    public static int deep(Node root) {
        int deep = 0;
        if (root == null) {
            return 0;
        } else {
            int left = deep(root.getLeft());
            int right = deep(root.getRight());
            deep = (left > right) ? left : right;
        }
        return deep;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.create();
        System.out.println("先序遍历，");
        bt.firstOrder(bt.root);
        System.out.println("先序遍历，");
        bt.firstOrderNoRecursion(bt.getRoot());
        System.out.print("********************\n");
        System.out.println("中序遍历，");
        bt.middleOrder(bt.getRoot());
        System.out.println("中序遍历，");
        bt.middleOrderNoRecursion(bt.root);
        System.out.print("********************\n");
        System.out.println("后序遍历，");
        bt.lastOrder(bt.getRoot());
        System.out.println("后序遍历，");
        bt.lastOrder(bt.root);
    }
}
