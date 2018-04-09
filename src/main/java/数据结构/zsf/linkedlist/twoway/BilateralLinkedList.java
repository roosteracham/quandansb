package 数据结构.zsf.linkedlist.twoway;


import 数据结构.zsf.node.BilateralNode;

public class BilateralLinkedList {

	private BilateralNode head = null;
	private BilateralNode last = null;
	private int length = 0;
	//����ĳ���
	public int getLength() {
		return length;
	}
	//������ݣ�����������ͷ��,head�����½ڵ�
	public void add(Object data) {

		BilateralNode temp = new BilateralNode(data);
		head = temp;
		temp.setNextNode(head.getNextNode());
		head.getNextNode().setPreNode(temp);
		if(head == null) {//�����������ͷ��㣬β�ڵ�Ҳָ��ͷ���
			head = temp;
			last = temp;
			return;
		}else {
			temp.setPreNode(head);
			temp.setNextNode(head.getNextNode());
			head.getNextNode().setPreNode(temp);
			head.setNextNode(temp);
		}
		length++;
	}
	//ָ��λ���������,�ҵ�ָ��λ��ǰһ���ڵ㣬
	public void add(int index, Object data) {
		if(index >= 0 && index <= length) {
			if(index == 0) {
				
			}
			BilateralNode temp = head;
			BilateralNode tempPre = head;
			int i = 0;
			while(temp.getNextNode() != null) {
				if(i == index) {
					break;
				}
				tempPre = temp;
				temp = temp.getNextNode();
			}
			
		}
	}
	//ɾ������
	
	//��ȡָ��λ������
}
