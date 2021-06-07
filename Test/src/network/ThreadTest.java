package network;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Thread c1 = new Counter(2);
			Thread c2 = new Counter(10);
			c1.start();
			c2.start();
			
	}
}
class Counter extends Thread{
	private int start;
	public Counter(int start) {
		this.start=start;
	}
	public void run() {
		for(int i = start ; i< (start+10);i++) {
			System.out.println(i);
			
		}
	}
	
}
