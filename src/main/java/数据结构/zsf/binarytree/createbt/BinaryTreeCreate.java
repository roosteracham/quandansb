package 数据结构.zsf.binarytree.createbt;


import 数据结构.binarytree.BinaryTree;
import 数据结构.binarytree.Node;
import 数据结构.zsf.linkedlistqueue.LinkedListQueue;

import java.io.IOException;
import java.util.Scanner;

public class BinaryTreeCreate {
	
	//���򴴽�������
	/**
	 * �����һ�����ݺϷ����򴴽����ڵ㣬�������ڵ�����У�������Ϸ����������
	 * ������в��գ��򵯳�һ���ڵ���Ϊ���ڵ㣬����Ϸ����򴴽��ڵ���Ϊ���ڵ����ڵ㣬�������
	 * ������Ϸ������ش����ڵ㣬�������룬����Ϸ����򴴽��ڵ���Ϊ���ڵ���ҽڵ㣬�������
	 * @throws IOException 
	 */
	public static Node treeCreateLayer() throws IOException {
		LinkedListQueue<Node> queue = new LinkedListQueue<>();
		Node root = null;
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		//������벻��0���������ڵ㣬�������
		if(data != 0) {
			root = new Node(data);
			queue.add(root);
		}
		while(! queue.IsEmpty()) {//���в��գ������ڵ�
			Node tempRoot = queue.delete();
			int leftData = s.nextInt();
			if( leftData != 0) {//���벻Ϊ�գ��������ڵ����ڵ�
				Node leftNode = new Node(leftData);
				tempRoot.setLeft(leftNode);
				queue.add(leftNode);
			}
			int rData = s.nextInt();
			if( rData != 0) {//���벻Ϊ�գ��������ڵ����ڵ�
				Node rNode = new Node(rData);
				tempRoot.setRight(rNode);
				queue.add(rNode);
			}
		}
		return root;
	}
	public static void main(String[] args) throws Throwable {
		Node root = treeCreateLayer();
		BinaryTree bt = new BinaryTree();
		bt.firstOrder(root);
		System.out.println("aaaaa");
		bt.middleOrder(root);
	}
}
