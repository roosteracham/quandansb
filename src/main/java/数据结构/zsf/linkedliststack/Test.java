package 数据结构.zsf.linkedliststack;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListStack stack = new LinkedListStack();
		stack.push("a");
		stack.push("b");
		System.out.println(stack.pop() + "\t" + stack.pop());
		for(int i = 0;i < 20;i++) {
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		};
	}

}
