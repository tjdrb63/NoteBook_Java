import java.net.InetAddress;
import java.net.*;

public class Host2InetAddr {
	public static void main(String[] args)
	{
		String hostName ="www.naver.com";
		try {
			InetAddress address = InetAddress.getByName(hostName);
			System.out.println("IP¡÷º“:"+address.getHostAddress());
		}catch(UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
	
}
