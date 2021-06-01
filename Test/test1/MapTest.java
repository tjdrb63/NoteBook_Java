package test1;
import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		
		/*	맵은 인터페이스 이고 구현한 클래스가 
		 * 	HashMap, TreeMap, LinkedHashMap 3개가 있다
		 * 	그래서 Map 타입의 변수는 위의 3개타입의 객체를 수용할수 있다
		 * 	Map은 값을 < key , value> 쌍으로 저장한다.
		 * 	Map은 값을 <key, value> 쌍으로 저장한다.
		 * 	Map은 Generic 이다.
		 * 	클래스 , 메소드 내부에서 사용할 데이터 타입을 정하지않고
		 * 	실제 그 클래스 객체를 만들거나 메소드를 호출할 때
		 * 	사용할 데이터 타입을 파라미터로 받아서 처리하는 것
		 * 	학번을 키로, Student 객체를 값으로 Map에 저장.
		 * */
		Map<String, Student> st = new HashMap<>();
		
		// Map에 원소 (<Key, Value>로 구성된 entry)를 넣을때는
		// put 메소드를 사용  이미존재하는키값으로 put하면 기존원소를 replace하게됨
		// Map에서 원소(엔트리)를 읽을때는 get(key) 메소드를 사용
		
		st.put("20201234", new Student(20201234,"홍길동1"));
		st.put("20201235", new Student(20201235,"홍길동2"));
		st.put("20201236", new Student(20201236,"홍길동3"));
		st.put("20201237", new Student(20201237,"홍길동4"));
		st.put("20201238", new Student(20201238,"홍길동5"));
		//		원소값을 읽을때에는 키값을 줘야한다
		//		Student std ;//= st.get("20201237");
		//		System.out.println(std);
		Set<String> Keyset = st.keySet();
		
		Iterator<String> iter = Keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Student std = st.get(key);
			System.out.println(std);
		}
		//Entry의 Set:<Key,Value> pair의 Set
		Set<Map.Entry<String, Student>> entrySet = st.entrySet();
		Iterator<Map.Entry<String, Student>> iter2 = entrySet.iterator();
	
	}
	
}
class Student{
	int number;
	String name;
	
	public String toString() {
		return "[number:" + number + ",name:" + name + "]";
	}
	public Student(int number , String name)
	{
		this.number = number;
		this.name =name;
	}
}
