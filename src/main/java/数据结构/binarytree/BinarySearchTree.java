package 数据结构.binarytree;
/**
 * ����������
 * 1���ǿ��������ļ�ֵС�ڸ��ڵ�ļ�ֵ
 * 2���ǿ��������ļ�ֵ���ڸ��ڵ�ļ�ֵ
 * 3�������������Ƕ���������
 * 
 * �Զ�������������������������õ�һ����С�����˳������
 * @author gpp
 *
 */
public class BinarySearchTree {

	private Node root = null;
	private Node parent = null;
	//���������������ض�Ԫ��,�ݹ�ʵ��
	@SuppressWarnings("null")
	public Node findElement(Node root, Object data) {
		Node element = null;
		if(root != null) {
			if(data.equals(root.getData())) {
				element = root;
			}else if((int) data < (int) root.getData()) {
				findElement(root.getLeft(), data);
			}else {
				findElement(root.getRight(), data);
			}
		}
		return element;
	}
	//���������������ض�Ԫ��,����ʵ��
	public Node findElementIterable(Node root,Object data) {
		Node element = null;
		while(root != null) {
			if((int) data < (int) root.getData()) {
				findElementIterable(root.getLeft(), data);
			}else if((int) data > (int) root.getData()) {
				findElementIterable(root.getRight(), data);
			}else {
				element = root;
			}
		}
		return element;
	}
	//������СԪ�أ��ݹ�ʵ��
	public Object findMin(Node root) {
		Object data = null;
		if(root == null) {
			data = null;
		}else if(root.getLeft() == null){
			data = root.getData();
		}else {
			findMin(root.getLeft());
		}
		return data;
	}
	//������СԪ�أ�����ʵ��
	public Object findMinIterable(Node root) {
		Object data = null;
		while(root != null) {
			if(root.getLeft() == null) {
				data = root.getLeft().getData();
			}else {
				root = root.getLeft();
			}
		}
		return data;
	}
	//�������Ԫ�أ��ݹ�ʵ��
	public Object findMax(Node root) {
		Object data = null;
		if(root == null) {
			data = null;
		}else if(root.getRight() == null){
			data = root.getData();
		}else {
			findMax(root.getRight());
		}
		return data;
	}
	//�������Ԫ�أ�����ʵ��
	public Object findMaxIterable(Node root) {
		Object data = null;
		while(root != null) {
			if(root.getLeft() == null) {
				data = root.getRight().getData();
			}else {
				root = root.getRight();
			}
		}
		return data;
	}
	//�����������Ĳ���
	public Node insert(Node root, Object data) {
		if(root == null) {
			root = new Node(data);
		}else {
			if((int) data < (int) root.getData()) {
				root.setLeft(insert(root.getLeft(), data));
			}else if((int) data > (int) root.getData()) {
				root.setRight(insert(root.getRight(), data));
			}
		}
		//this.root = root;
		return root;
	}
	//�Ƿ�Ϊ��
	public boolean isEmpty(Node root) {
		return root == null;
	}
	//����������ɾ������
	/**
	 * 1��Ҫɾ������Ҷ�ڵ�
	 * 2��Ҫɾ���Ľڵ�ֻ��һ�����ӽڵ�
	 * 3��Ҫɾ���Ľڵ����������ӽڵ�
	 */
	public Node delete(Node root, Object data) {
		Node node = null;
		parent = this.root;
		if(root == null) {
			System.out.println("�������޷�����ɾ������������");
		}else if((int) data < (int) root.getData()) {//���������ݹ�ɾ��
			root.setLeft(delete(root.getLeft(), data));
		}else if((int) data > (int) root.getData()) {//���������ݹ�ɾ��
			root.setRight(delete(root.getRight(), data));
		}else {//�ҵ�Ҫɾ����Ԫ�ص�λ��
			//���Ҫɾ���Ľڵ����������ӽڵ�
			node = root;
			if(root.getLeft() != null && root.getRight() != null) {//���������ӽڵ�
				//parent = root;
				Object tempData = findMin(root.getRight());
				root.setData(tempData);
				//����������ɾ����СԪ��
				root.setRight(delete(root.getRight(), root.getData()));
			}else {//Ҫɾ���Ľڵ���һ������û�к��ӽڵ�
				if(root.getLeft() == null && root.getRight() != null) {//ֻ���Һ��ӽڵ�
					parent.setRight(root.getRight());
					root.setData(null);
					root.setRight(null);
				}else if(root.getRight() == null && root.getLeft() != null) {//ֻ�����ӽڵ�
					parent.setRight(root.getLeft());
					root.setData(null);
					root.setLeft(null);
				}else {//û�к��ӽڵ�
					if(parent == root) {
						this.root = null;
					}else {
						//parent.setLeft(null);
						parent.setRight(null);
					}
				}
			}
		}
		return node;
	}
	//�������,�ȷ��ʸ��ڵ㣬�ڷ�����ڵ㣬������ҽڵ�
		public void firstOrder(Node root) {
			if(root != null) {
				System.out.println(root.getData());
				firstOrder(root.getLeft());
				firstOrder(root.getRight());
			}
		}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.insert(bst.root, 1);
		bst.insert(bst.root, 2);
		bst.insert(bst.root, 0);
		bst.firstOrder(bst.root);
		Node node = bst.delete(bst.root, 1);
		System.out.println(node.getData());
		bst.firstOrder(bst.root);
	}
}
