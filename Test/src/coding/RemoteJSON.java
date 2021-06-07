package coding;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.google.gson.Gson;

public class RemoteJSON {

	public static void main(String[] args) throws Exception {
		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url =new URL(site);
		URLConnection con = url.openConnection();
		InputStream stream = con.getInputStream();
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader buffReader = new BufferedReader(reader);
		
		String line = null;
		
		StringBuffer buf = new StringBuffer();
		
		
		Gson gson = new Gson();
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/oop","root","1234");
		String 
		while((line = buffReader.readLine()) != null) { 
			buf.append(line);		}
		
		Post[] posts = gson.fromJson(buf.toString(),Post[].class);
		for(Post p : posts) {
			System.out.println("userID :"+p.getUserId());
		}
		
	}

}

class Person {
	//JavaBean
	// 1.private member 변수에 대한 public getter와 setter를 가진다.
	// 2.default 생성자를 가진다.
	private String name;
	private int age;
	private boolean graduated;
	
//	public Person() {}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGraduated() {
		return graduated;
	}
	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}
	
}
