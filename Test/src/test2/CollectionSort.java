package test2;

import java.util.*;

class testsample implements Comparable<testsample>{

	int number;
	String name;
	
	public testsample(int number,String name){
		this.number=number;
		this.name=name;
	
	}
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(testsample o) {
		return number-o.number;
	}
	
}

public class CollectionSort {

	public static void main(String[] args) {
//		String sam[]= {"Abc","abc","Ac","ac"};
//		java.util.List<String> list = Arrays.asList(sam);
//		Collections.sort(list);
//		System.out.println(list);
		testsample arr[] = {
				new testsample(1000,"x"),
				new testsample(999,"y"),
				new testsample(1001,"z"),
		};
		
		java.util.List<testsample> list = Arrays.asList(arr);
//		Collections.sort(list);    데이터 정렬하기
//		Collections.shuffle(list); 데이터 섞기
		System.out.println(list);
		
		
	
	}

}
