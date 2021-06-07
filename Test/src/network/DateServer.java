package coding;

import java.io.*;
import java.net.*;
import java.util.Calendar;


public class DateServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = new ServerSocket(9100);
		
		while(true) {
			/* 클라이언트 요청을 기다리거나
			 * 클라이언트와 요청이 설립되면 새로운 socket을 생성해
			 * 그 클라이언트와 통신한다
			 * 
			 * */
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 접속되었음...["+socket.getPort());
			
			OutputStream ostream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(ostream,true);
			writer.println(Calendar.getInstance().getTime());
			socket.close();
			System.out.println("클라이언트와의 연결을 종료합니다.");
			
			
		}

	}

}
