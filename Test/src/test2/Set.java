package test2;

import java.util.*;

public class Set {
	public static void main(String[] args) {
		//�ڷ� �ߺ��ȵ�
		HashSet<String> set = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
			
		set.add("a");
		set.add("b");
		set.add("c");
		set2.add("a");
		set2.add("d");
		set2.add("e");
		
		set.addAll(set2);//������
		set.removeAll(set2); //������
		set.retainAll(set2); //������
		
	}
}
