package coding;

import java.net.*;
import java.io.*;

public class URLConnectionReader {

	public static void main(String[] args) throws IOException {
		// URL 객체 생성
		URL site = new URL("https://www.naver.com");
		// 연결 설립
		URLConnection con =site.openConnection(); // 연결
		// 연결로부터 스트림을 얻어야한다
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
