package 数据结构.zsf.linkedlistqueue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	LinkedListQueue queue = new LinkedListQueue();
		queue.add("a");
		queue.add(29);
		queue.add(new Person("rooster", 20));
		System.out.println(queue.delete() + "\t" + queue.delete());
		Person person = (Person) queue.delete();
		System.out.println(person.getName() + "\t" + person.getAge());*/
		
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		queue.add("a");
		queue.add("b");
		queue.add(29);
		//queue.add(new Person("rooster", 20));
		System.out.println(queue.delete() + "\t" + queue.delete());
		//Person person = (Person) queue.delete();
		//System.out.println(person.getName() + "\t" + person.getAge());
	}

}
