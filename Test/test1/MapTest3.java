package test1;

import java.util.*;

public class MapTest3 {

		public static void main(String[] args)
		{
			test();
		}
		private static void test() {
			String sample = "What a radical idea, the great gift that our Founders gave to us. " +
					"The freedom to chase our individual dreams through our sweat, and toil, " +
					"and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
					"For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
					"It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
					"It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
					"It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
					"It’s why GIs gave their lives at Omaha Beach and Iwo Jima; " +
					"Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";
				/*
				 * 한 문자열을 각 단어별로 쪼개보자
				 * 
				 * 
				 **/
			Map<String, Integer> map =new TreeMap<>(); // 키값을 기준으로 정렬함
			//MAP<Key, Value>의 쌍으로 저장한다
			StringTokenizer st =new StringTokenizer(sample,",.;");
			while(st.hasMoreElements()) {
				String str = st.nextToken();
				System.out.println(str);
				Integer value = map.get(str);
				if(value == null) {
					map.put(str,1);
				}
				else
				{
					map.put(str, value+1);
				}
			}
			
			//Integer freq = map.get("freedom");
			//System.out.println("단어는 "+"freq"+"번 출현했습니다");
			
			Set<String> keyset = map.keySet();
			Iterator<String> iter = keyset.iterator();
			
			while(iter.hasNext())
			{
				String key = iter.next();
				Integer value = map.get(key);
				System.out.println(key + ":" + value);
			}

			Set<Map.Entry<String, Integer>>entrySet = map.entrySet(); //Map.Entry<String,Integer> 객체를 원소로 가지는 set
			Iterator<Map.Entry<String, Integer>> eIter = entrySet.iterator();
			while(eIter.hasNext()) {
				Map.Entry<String, Integer> entry = eIter.next();
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
	
}
