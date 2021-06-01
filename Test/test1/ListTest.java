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
		//list.add("자동차");
		for (String s : sArr) list.add(s);
		System.out.println(list);// ArratList의 toString() 메소드가 이용

		for (int i = 0; i< list.size(); i++) {
			System.out.print(list.get(i)+ " ");
			System.out.println();

			for (String s : list) System.out.print(s + " ");
			System.out.println();

			Iterator<String> iter = list.iterator();
			//unchecked excaeption은 버그다
			//이런 exception 자체가 발생하지 않게 코딩해라..

			while(iter.hasNext())
				System.out.print(iter.next() + " ");
			System.out.println();

			// overloading된 add 메소드로 원소를 중간에 삽입할수있다
			//list.add[1, "벚꽃"];

			//원소삭제
			//list.remove();

			iter = list.iterator();
			while(iter.hasNext())
				System.out.print(iter.next() + " ");
			System.out.println();

			//0번인덱스가 삭제되어도 뒤에것들이 당겨서 0번인덱스자리가 채워진다.

			iter = list.iterator();
			System.out.print(iter.next() + " ");
			System.out.println();

			//		System.out.println(iter.next());
			//		System.out.println(iter.next());
			//		System.out.println(iter.next());
			//		System.out.println(iter.next());
			//		System.out.println(iter.next());

			//	System.out.println(iter.next());// 익섹션이 일어남
		}

		// ArrayList -> LinkedList로 바꾸어도 구저적으로 아무문제없다
		// 내부구조만 다름
	}
}
