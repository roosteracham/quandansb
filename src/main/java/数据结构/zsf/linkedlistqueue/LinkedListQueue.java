package 数据结构.zsf.linkedlistqueue;
/**
 * ����ʵ�ֵĶ��У����������ȳ�
 * ��Ԫ�ز��뵽���е�β��������ͷԪ��
 * ��������
 *����Ԫ��
 *ɾ��Ԫ��
 *�Ƿ�Ϊ��
 * @author gpp
 *
 */
public class LinkedListQueue<T> {
	//���е�ͷ���,β�ڵ�
	private QueueNode head, last;
	private int length = 0;
	private class QueueNode{
		T data;
		QueueNode next;
		public QueueNode() {
			// TODO Auto-generated constructor stub
			this.data = null;
			this.next = null;
		}
		public QueueNode(T data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.next = null;
		}
	}
	// * ��������
	public LinkedListQueue() {
		// TODO Auto-generated constructor stub
		head = new QueueNode();
	}
	//*����Ԫ��
	public void add(T data) {
		QueueNode newNode = new QueueNode(data);
		if(length == 0) {
			this.head.next = newNode;
			last = newNode;
			length ++;
			return ;
		}else {
			last.next = newNode;
			last = newNode;
			length ++;
		}
	}
	// *ɾ��Ԫ��
	public T delete() {
		if(IsEmpty()) {
			throw new RuntimeException("�ն��С���");
		}else {
			QueueNode temp = this.head.next;
			this.head.next = temp.next;
			T data = (T) temp.data;
			temp = null;
			length --;
			return data;
		}
	}
	//*�Ƿ�Ϊ��
	public boolean IsEmpty() {
		return length == 0;
	}
}
