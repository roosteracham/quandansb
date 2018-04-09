package 数据结构.zsf.linkedlist.oneway;

public interface MyList<T> {

	//��������
	void add(T data);
	//ɾ������
	T delete(int index);
	//�������
	T get(int index);
	//���س���
	int length();
	//ָ��λ�ò�������
	void add(int index, T data);
}
