package 数据结构.zsf.node;

public class OneWayNode {

	//�ڵ㣬�ڲ��࣬�洢��������
	private OneWayNode next = null;
	private Object data = 0;
	public OneWayNode(Object data) {
		// TODO Auto-generated constructor stub
		this.setData(data);
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public OneWayNode getNext() {
		return next;
	}
	public void setNext(OneWayNode next) {
		this.next = next;
	}
}
