package test2;

import java.util.*;

public class Set {
	public static void main(String[] args) {
		//자료 중복안됨
		HashSet<String> set = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
			
		set.add("a");
		set.add("b");
		set.add("c");
		set2.add("a");
		set2.add("d");
		set2.add("e");
		
		set.addAll(set2);//합집함
		set.removeAll(set2); //차집합
		set.retainAll(set2); //교집합
		
	}
}
