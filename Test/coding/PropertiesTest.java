package coding;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import sun.jvm.hotspot.tools.SysPropsDumper;

public class PropertiesTest {
	public static void main(String[] args) {
//		Map<String, String> env = System.getenv();
//		Set<String> keys = env.keySet();
//		for(String Key : Keys) {
//			System.out.println(Key + " : "+ env.get(key));
//		}
//	}
		
	Properties props = new Properties();
	File file =new File(("resources/dic.props");
	
	try(FileReader reader =new FileReader("resources/dic.props"))
;	
	
	Set<Object> Keys = props.keySet();
	
	
}
