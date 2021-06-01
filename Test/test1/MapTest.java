package test1;
import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		
		/*	���� �������̽� �̰� ������ Ŭ������ 
		 * 	HashMap, TreeMap, LinkedHashMap 3���� �ִ�
		 * 	�׷��� Map Ÿ���� ������ ���� 3��Ÿ���� ��ü�� �����Ҽ� �ִ�
		 * 	Map�� ���� < key , value> ������ �����Ѵ�.
		 * 	Map�� ���� <key, value> ������ �����Ѵ�.
		 * 	Map�� Generic �̴�.
		 * 	Ŭ���� , �޼ҵ� ���ο��� ����� ������ Ÿ���� �������ʰ�
		 * 	���� �� Ŭ���� ��ü�� ����ų� �޼ҵ带 ȣ���� ��
		 * 	����� ������ Ÿ���� �Ķ���ͷ� �޾Ƽ� ó���ϴ� ��
		 * 	�й��� Ű��, Student ��ü�� ������ Map�� ����.
		 * */
		Map<String, Student> st = new HashMap<>();
		
		// Map�� ���� (<Key, Value>�� ������ entry)�� ��������
		// put �޼ҵ带 ���  �̹������ϴ�Ű������ put�ϸ� �������Ҹ� replace�ϰԵ�
		// Map���� ����(��Ʈ��)�� �������� get(key) �޼ҵ带 ���
		
		st.put("20201234", new Student(20201234,"ȫ�浿1"));
		st.put("20201235", new Student(20201235,"ȫ�浿2"));
		st.put("20201236", new Student(20201236,"ȫ�浿3"));
		st.put("20201237", new Student(20201237,"ȫ�浿4"));
		st.put("20201238", new Student(20201238,"ȫ�浿5"));
		//		���Ұ��� ���������� Ű���� ����Ѵ�
		//		Student std ;//= st.get("20201237");
		//		System.out.println(std);
		Set<String> Keyset = st.keySet();
		
		Iterator<String> iter = Keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Student std = st.get(key);
			System.out.println(std);
		}
		//Entry�� Set:<Key,Value> pair�� Set
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
