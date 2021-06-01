package test1;

import java.util.*;

public class Callnumber {
	public static void main(String[] args)
	{
		Map<String,String> aPhone = new TreeMap<>();
		aPhone.put("박","1234");
		aPhone.put("김","1222");
		aPhone.put("장","2222");

		Map<String,String> bPhone = new TreeMap<>();
		bPhone.put("무","1155");
		bPhone.put("야","3333");
		bPhone.put("호","9999");
		
		Map<String, Map<String, String>> phoneBook = new HashMap<>();
		phoneBook.put("A반",aPhone);
		phoneBook.put("B반",bPhone);
		
		Map<String, Map<String, String>> banPB = new HashMap<>();
		banPB.put("A반", aPhone);
		banPB.put("B반", bPhone);
		
		banPB.forEach((S,M)->{
				M.forEach((n,p)->{
					System.out.println(S+"의 "+n+" 전화번호:"+p);
				});
		});
		
		
		
	}
	
	
	
}
