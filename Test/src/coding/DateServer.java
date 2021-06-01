package coding;

import java.io.*;
import java.net.*;
import java.util.Calendar;


public class DateServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = new ServerSocket(9100);
		
		while(true) {
			/* Ŭ���̾�Ʈ ��û�� ��ٸ��ų�
			 * Ŭ���̾�Ʈ�� ��û�� �����Ǹ� ���ο� socket�� ������
			 * �� Ŭ���̾�Ʈ�� ����Ѵ�
			 * 
			 * */
			Socket socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ���...["+socket.getPort());
			
			OutputStream ostream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(ostream,true);
			writer.println(Calendar.getInstance().getTime());
			socket.close();
			System.out.println("Ŭ���̾�Ʈ���� ������ �����մϴ�.");
			
			
		}

	}

}
