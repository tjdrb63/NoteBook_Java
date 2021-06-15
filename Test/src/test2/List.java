package test2;

import java.util.*;

public class List {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list2.add("a");
		list2.add("b");
		
		Iterator e = list.iterator();
		while(e.hasNext()) {
			String s = (String)e.next();
			System.out.println(e);
		}
	}

}
