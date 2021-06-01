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
		//				System.out.println(file.getAbsolutePath()+"������");
		//			}else {
		//				System.out.println(file.getAbsolutePath()+"������");
		//			}
		//���� ������ ����
		//���� ������ �а� ������ strem ��ü�� �̿��ؾ��Ѵ�.
		/*
		 ���� ���� Input Stream 
		  ������ Output Stream
		  Stream�� �⺻������ Byte Stream
		  �׷��� ���ڴ����� �а� �� ���� ���� ��Ʈ���� �̿��ϴ� ���� ��.
		���� ������ �Է� ��Ʈ���� Reader��ü�� ǥ���ȴ�.
		���� ������ ��� ��Ʈ���� Writer��ü�� ǥ���ȴ�.
		 */

		int cnt = 0;
		BufferedReader bReader = null;
		try {
			//fileReader�� �ѹ��ھ� ���� �� ���
			FileReader fileReader = new FileReader(file);
			//���� ������ �б� ���ؼ� BufferedReader �̿�
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
					System.out.println("�ܾ� ��(���� ����):" + cnt);
				}
		}
	}
}