package test2;

import java.io.*;
import java.net.*;

import com.google.gson.Gson;

public class testGson {

	public static void main(String[] args) throws Exception{
		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);
		
		URLConnection con = url.openConnection();
		InputStream stream = con.getInputStream();
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader bf = new BufferedReader(reader);
		
		String line = null;
		String json = "";
		while((line=bf.readLine()) != null) {
			json += line;
		}
		
		System.out.println(json);
		Gson gson = new Gson();
		Post[] posts= gson.fromJson(json,Post[].class);
		
		for(Post s : posts) {
			System.out.println(s.getUserId());
		}
	}

}
