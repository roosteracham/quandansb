package 数据结构.zsf.node;

public class BilateralNode {

	private BilateralNode preNode;
	private BilateralNode nextNode;
	private Object data;
	public Object getData() {
		return data;
	}
	public void setPreNode(BilateralNode preNode) {
		this.preNode = preNode;
	}
	public void setNextNode(BilateralNode nextNode) {
		this.nextNode = nextNode;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public BilateralNode getNextNode() {
		return nextNode;
	}
	public BilateralNode getPreNode() {
		return preNode;
	}
	public BilateralNode(Object data) {
		super();
		this.data = data;
	}
}
