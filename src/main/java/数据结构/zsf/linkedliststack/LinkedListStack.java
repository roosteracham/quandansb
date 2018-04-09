package 数据结构.zsf.linkedliststack;
/**
 * ����ʵ��
 * ��ͷ�ڵ�Ķ�ջ
 *������ջ
 *��ջ�Ƿ�Ϊ��
 *pop����
 *push����
 * @author gpp
 *
 */
public class LinkedListStack {

	//��ջ�Ľڵ�������������һ��ָ��
	public class StackNode{
		private Object data;
		private StackNode next;
		public StackNode() {
			// TODO Auto-generated constructor stub
			this.data = null;
			this.next = null;
		}
		public StackNode(Object data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	//ͷ���
	private StackNode top = null/*new StackNode()*/;
	//��ջ�����
	private int length = 0;
	//������ջ
	public LinkedListStack() {
		// TODO Auto-generated constructor stub
		top = new StackNode();
	}
	// *��ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return this.top.next == null;
	}
	//*pop���������ǵ���β����Ԫ��
	public Object pop() {
		Object temp = null;
		if(isEmpty()) {
			throw new RuntimeException("��ջΪ�ա�");
		}else {
			temp = top.next.data;
			top.next = top.next.next;
		}
		length --;
		return temp;
	}
	//*push����,���ǲ��뵽β��
	public boolean push(Object data) {
		StackNode temp = new StackNode(data);
		temp.next = top.next;
		top.next = temp;
		length ++;
		return true;
	}
	public int getLength() {
		return length;
	}
}
