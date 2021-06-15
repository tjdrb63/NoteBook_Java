package test2;

import java.io.*;
import java.net.*;

public class Urlget {

	public static void main(String[] args) throws Exception {
		
		
		String site="https://www.google.com/search?q=java";
		URL url = new URL(site);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent","Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("Responce code : "+ responseCode);
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line;
		StringBuffer buf = new StringBuffer();
		while((line = reader.readLine()) != null) {
			buf.append(line);
		}
		reader.close();
		System.out.println(buf);
		
	}

}
