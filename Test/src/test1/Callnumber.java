package test1;

import java.util.*;

public class Callnumber {
	public static void main(String[] args)
	{
		Map<String,String> aPhone = new TreeMap<>();
		aPhone.put("��","1234");
		aPhone.put("��","1222");
		aPhone.put("��","2222");

		Map<String,String> bPhone = new TreeMap<>();
		bPhone.put("��","1155");
		bPhone.put("��","3333");
		bPhone.put("ȣ","9999");
		
		Map<String, Map<String, String>> phoneBook = new HashMap<>();
		phoneBook.put("A��",aPhone);
		phoneBook.put("B��",bPhone);
		
		Map<String, Map<String, String>> banPB = new HashMap<>();
		banPB.put("A��", aPhone);
		banPB.put("B��", bPhone);
		
		banPB.forEach((S,M)->{
				M.forEach((n,p)->{
					System.out.println(S+"�� "+n+" ��ȭ��ȣ:"+p);
				});
		});
		
		
		
	}
	
	
	
}
