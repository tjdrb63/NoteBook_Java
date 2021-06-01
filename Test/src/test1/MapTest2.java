package test1;

public class MapTest2 {

	public static void main(String[] args) {
		String[] str = {"To","be","or","not","to","be","is","a","problem"};
		/*
		 * 	Map에다가 단어를 키로 , 그단어가 출현한 회수를값으로 저장
		 *  제네릭의 타입 파라미터는 기본타입을 허용하지않는다.
		 */
		
		Map<String, Integer> map = new HashMap<>();
		// str 배열에 각원소에 대해서
		// 그 원소를 키로 가지는 엔트리가 있는지 검사
		// 만약에 그러한 엔트리가 있으면
		//	있다 라는것은 map.get(key) 반환되는 값이 null이 아니라는 의미
		// Integer count = map.get(key); 	//
		// 그러한 엔트리가 없으면
		// 이 Key에 해당하는 단어는 처음 나온거다, 그럼 Map에 추가.
		// map.put(key,	1); //자바는 auto boxing  -> 기본타입값을 대응되는 객체타입값으로 자동변환
		e	
	
	}

}
