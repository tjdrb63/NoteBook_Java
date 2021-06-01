package test1;

import java.util.*;

public class sort {
	public static void main(String[] args)
	{
		test();	
	}
	
	private static void test() {
		ArrayList<Student> list = new ArrayList<>();
		Random random = new Random();
		
		for(int i=0 ; i<10 ; i++) {
			list.add(new Student("ÀÌ¸§"+1,random.nextInt(100)+1));
		}
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}
	class Student implements Comparable<Student>{
		private String name;
		private int grade;
		
		public String toString() {
			return "[name:"+name+"grade"+grade+"]";
		}
		public Student(String name, int grade) {
			super();
			this.name = name;
			this.grade =grade;
		}	
		@Override
		public int compareTo(Student o) {
			return this.grade - o.grade;
		}
		
	}
}

