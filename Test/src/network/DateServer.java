package network;

import java.io.*;
import java.net.*;
import java.util.Calendar;


public class DateServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9100);
		while(true) {
			/* Ŭ���̾�Ʈ ��û�� ��ٸ��ų�
			 * Ŭ���̾�Ʈ�� ��û�� �����Ǹ� ���ο� socket�� ������
			 * �� Ŭ���̾�Ʈ�� ����Ѵ�
			 * 
			 * */
			Socket socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ���...["+socket.getPort());
			
			//Ŭ���̾�Ʈ�� ��û�� �����Ǹ� ���ο� socket�� ������ �� Ŭ���̾�Ʈ�� ����Ѵ�.
			OutputStream ostream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(ostream,true);
			writer.println(Calendar.getInstance().getTime());
			socket.close();
			System.out.println("Ŭ���̾�Ʈ���� ������ �����մϴ�.");
			
			Thread thread = new NewSocket(socket);
			thread.start();
			
		}

	}
		
}
class NewSocket extends Thread{
	Socket socket;
	public NewSocket(Socket socket) {
		this.socket=socket;
	}
	
	public void run(){
		
		try {
			OutputStream ostream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(ostream,true);
			writer.println(Calendar.getInstance().getTime());
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		while(true) {
			System.out.println("1");
		}
	}
	
}