package test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	public  static void main(String[] args) {
		test1();
	}
	public  static void test1() {
		List<String> list = new ArrayList<>();
		String[] sArr = {"a","b","c","d","e"};
		//list.add("�ڵ���");
		for (String s : sArr) list.add(s);
		System.out.println(list);// ArratList�� toString() �޼ҵ尡 �̿�

		for (int i = 0; i< list.size(); i++) {
			System.out.print(list.get(i)+ " ");
			System.out.println();

			for (String s : list) System.out.print(s + " ");
			System.out.println();

			Iterator<String> iter = list.iterator();
			//unchecked excaeption�� ���״�
			//�̷� exception ��ü�� �߻����� �ʰ� �ڵ��ض�..

			while(iter.hasNext())
				System.out.print(iter.next() + " ");
			System.out.println();

			// overloading�� add �޼ҵ�� ���Ҹ� �߰��� �����Ҽ��ִ�
			//list.add[1, "����"];

			//���һ���
			//list.remove();

			iter = list.iterator();
			while(iter.hasNext())
				System.out.print(iter.next() + " ");
			System.out.println();

			//0���ε����� �����Ǿ �ڿ��͵��� ��ܼ� 0���ε����ڸ��� ä������.

			iter = list.iterator();
			System.out.print(iter.next() + " ");
			System.out.println();

			//		System.out.println(iter.next());
			//		System.out.println(iter.next());
			//		System.out.println(iter.next());
			//		System.out.println(iter.next());
			//		System.out.println(iter.next());

			//	System.out.println(iter.next());// �ͼ����� �Ͼ
		}

		// ArrayList -> LinkedList�� �ٲپ ���������� �ƹ���������
		// ���α����� �ٸ�
	}
}
