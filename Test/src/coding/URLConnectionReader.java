package coding;

import java.net.*;
import java.io.*;

public class URLConnectionReader {

	public static void main(String[] args) throws IOException {
		// URL ��ü ����
		URL site = new URL("https://www.naver.com");
		// ���� ����
		URLConnection con =site.openConnection(); // ����
		// ����κ��� ��Ʈ���� �����Ѵ�
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
