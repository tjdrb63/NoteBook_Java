package test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SetTest {
	public  static void main(String[] args) {
		test1();
	}
	public  static void test1() {
		File file = new File("wordbook.txt");
		//		if (file.exists() == true) {
		//				System.out.println(file.getAbsolutePath()+"존재함");
		//			}else {
		//				System.out.println(file.getAbsolutePath()+"존재함");
		//			}
		//파일 내용일 읽자
		//파일 내용을 읽고 쓰려면 strem 객체를 이용해야한다.
		/*
		 읽을 떄는 Input Stream 
		  쓸때는 Output Stream
		  Stream은 기본적으로 Byte Stream
		  그런데 문자단위로 읽고 쓸 떄는 문자 스트림을 이용하는 것이 편리.
		문자 단위로 입력 스트림은 Reader객체로 표현된다.
		문자 단위의 출력 스트림은 Writer객체로 표현된다.
		 */

		int cnt = 0;
		BufferedReader bReader = null;
		try {
			//fileReader는 한문자씩 읽을 때 사용
			FileReader fileReader = new FileReader(file);
			//라인 단위로 읽기 위해서 BufferedReader 이용
			//BufferedReader bReader = new BufferedReader(fileReader);
			bReader = new BufferedReader(fileReader);
			String line =null;
			//	String line = bReader.readLine();
			while ((line=bReader.readLine()) != null) {	
				System.out.println(line);
				cnt++;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{ 
			try {
				bReader.close(); }catch(Exception e){

				};

				{
					System.out.println("단어 수(중폭 포함):" + cnt);
				}
		}
	}
}