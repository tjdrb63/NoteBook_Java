package coding;

import java.net.*;
import java.io.*;

public class HTTPURLTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String site = "https:/www.google.com/search?q=java";
		URL url = new URL(site);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		int code = con.getResponseCode();
		System.out.println("Response code:"+code);
		
		InputStream stream = con.getInputStream();
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);
		String line =null;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println();
	
	}

}
