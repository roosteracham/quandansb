package 数据结构.zsf.linkedlist.oneway;

public class Test {
public static void main(String[] args) {
	LinkedList linkedList = new LinkedList();
	linkedList.add(2);
	linkedList.add(5);
	linkedList.add(4);
	linkedList.add(6);
	System.out.println("����ĳ����ǣ�" + linkedList.length());
	System.out.println("huoqu �ڼ������� " + linkedList.get(2));
	for (int i = 0; i < linkedList.length(); i++) {
		System.out.println("\t" + linkedList.get(i));
	}
	linkedList.remove(1);
	//linkedList.add(1,20);
	System.out.println("����ĳ����ǣ�" + linkedList.length());
	System.out.println("huoqu �ڼ������� " + linkedList.get(2));
	for (int i = 0; i < linkedList.length(); i++) {
		System.out.println("\t" + linkedList.get(i));
	}
	
}
}
