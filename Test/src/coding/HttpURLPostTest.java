package coding;

import java.net.*;

public class HttpURLPostTest {

	public static void main(String[] args) throws Exception{
		String site = "http://localhost:8080/board/test";
		URL url = new URL(site);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
	}
}
