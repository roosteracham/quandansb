package 数据结构.zsf.linkedlist.oneway;

import 数据结构.zsf.node.OneWayNode;

/**
 * 
 * ��������ʵ��
 * @author gpp
 *
 */
public class LinkedList { 
	private OneWayNode head = null;
	private OneWayNode last = null;
	private int length = 0;
	private OneWayNode current = null;
	private OneWayNode Pre;
	//�ڵ㣬�ڲ��࣬�洢��������
	public OneWayNode getHeadNode() {
		return this.head;
	}
	public OneWayNode getLastNode() {
		return this.last;
	}
	//����ĳ���
	public int length() {
		return length;
	}
	//�������в���һ���ڵ㣬���������β��
	public void add(Object data) {
		// TODO Auto-generated method stub
		OneWayNode newNode = new OneWayNode(data);
		//����ǿ��������ڵ���ڱ�ͷ
		length++;
		if(head ==null) {
			head = newNode;
			last = newNode;
			return;
		}
		//������ǿ����������ݲ鵽����β��
		//last����ָ�������β�������һ���ڵ�
		last.setNext(newNode);
		last = newNode;
	}
	
	public Object remove(int index) {
		// TODO Auto-generated method stub
		getNode(index);
		if(current == head) {
			head = head.getNext();
		}
		if(current == last) {
			last = Pre;
		}
		Pre.setNext(current.getNext());
		current.setNext(null);
		Object data = current.getData();
		length--;
		return data;
	}

	private void getNode(int index) {
		if(index >= 0 && index <=length - 1) {
			int i = 0;
			current = head;
			Pre = head;
			while(current.getNext() != null) {
				if(i == index) {
					break;
				}
				Pre = current;
				current = current.getNext();
				i++;
			}
		}
	}
	//��ȡ��index���ڵ�����
	public Object get(int index) {
		// TODO Auto-generated method stub
		getNode(index);
		Object data = current.getData();
		return data;
	}

	public void add(int index, Object data) {
		// TODO Auto-generated method stub
		getNode(index);
		OneWayNode temp = new OneWayNode(data);
		temp.setNext(current);
		Pre.setNext(temp);
		length++;
	}	
}
