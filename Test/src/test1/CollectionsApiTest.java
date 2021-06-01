package test1;

import java.util.*;

import javax.sound.midi.MidiChannel;




public class CollectionsApiTest {
	public static void main(String[] args)
	{
		//sortTest();
		
		List<Integer> list = new ArrayList();
		for(int i =1; i<=100;i++) {
			list.add(i);
		}	
		
		binarySearch(list,10);
		
		
	}
	
	public static<T extends Comparable<T>> int binarySearch(List<T> list, T Key) {
		
		int left = 0; 
		int right = list.size()-1;
		
		while(true) {
			int mid =(right+left)/2;
			//System.out.println(left + " / " + mid+ " / " + right +" "+list.get(mid));
			
			if(left > right) {
				System.out.println("원하는 키값이 없습니다");
				break;
			}
			
			if(Key == list.get(mid))
			{
				System.out.println(mid+1+"번째에 있습니다");
				break;
			}
			else if (Key > list.get(mid)) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}
			
			return mid;
		}
		
	}
	public static void sortTest() {
		String[] sample = {"A","B","a","b"};
		
		List<String> list = Arrays.asList(sample);
		Collections.sort(list);
		Collections.sort(list,(o1,o2)-> o1.compareToIgnoreCase(o2));
		System.out.println(list);
		
	}
	
	
}
