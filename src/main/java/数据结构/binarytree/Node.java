package 数据结构.binarytree;

public class Node {

	private Node left;
	private Node right;
	private Node parent;

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	private Object data;
	public Node() {
		// TODO Auto-generated constructor stub
		this.data = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	public Node(Object data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
