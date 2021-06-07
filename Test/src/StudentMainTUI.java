import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//Entity Ŭ����
class Student {
	int stuNum;			// �й�
	String name;		// �̸�
	String phone;
	
	// ������
	public Student(int stuNum, String name, String phone) {
		this.stuNum = stuNum;
		this.name = name;
		this.phone = phone;
	}
}


//Manager Ŭ����
class StudentManager{
	// Student ����� HashMap ����
	HashMap<Integer, Student> stuMap = new HashMap<Integer, Student>();
	
	// �ش� ������ �޾Ƽ� Student ��ü�� �����ؼ� �߰��ϵ��� �ۼ���!!!
	public void InputData(int stuNum, String name,  String phone) {	
		Student student = new Student(stuNum, name, phone);
		stuMap.put(stuNum, student);
	}
	
	// �й� ������ �޾Ƽ� ã�ƺ��� ������ ��ü ����, ��ã���� null ��ȯ�ϵ��� �ۼ���!!!!
	Student SearchData(int stuNum) {			
		Student result = null;	// ���ϰ�. ã���� ã�� ��ü�� �����ϰ�, ��ã���� null ������
		
		result = stuMap.get(stuNum);
		
		return result; // ��ã���� null ����!!
	}
	
}



//UI Ŭ����
class StudentUI{	
	
	StudentManager SM = new StudentManager();		// StudentManager ����
	public Scanner keyboard=new Scanner(System.in);	// �ܼ� �Է¿�
	
	
	// �ؽ�Ʈ �޴��� ��� �������ִ� �޼ҵ�
	void ShowMenu() {
		
		int choice;		// �޴� ���ÿ�
				
		while(true)
		{
			System.out.println("<< �л� ���� ���� >>");
			System.out.println("[1] �л� ���� �Է�");
			System.out.println("[2] �л� ���� �˻�");
			System.out.print("����: ");
			
			choice = keyboard.nextInt();
			//keyboard.nextL();
			
			switch(choice)
			{
			case 1:
				InputDataUI();
				break;
			case 2:
				SearchDataUI();
				break;
			}			
		}
	}
	
	void InputDataUI()
	{
		System.out.println("<< �л� ���� �Է� >>");
		System.out.print("�й�: ");
		int stuNum =keyboard.nextInt();
		
		System.out.print("�̸�: ");
		String name=keyboard.next();
		
		System.out.print("��ȭ��ȣ: ");
		String phone=keyboard.next();
		
		
		SM.InputData(stuNum, name, phone);		// Manager Ŭ�������� �Է��� �ϵ��� ������ �Ѱ���		

		System.out.println("�Է��� �Ϸ� �Ǿ����ϴ�. \n");

	}
	
	
	void SearchDataUI()
	{
		System.out.println("<< �л� ���� �˻� >>");
		System.out.print("�й�: ");
		int stuNum = keyboard.nextInt();
		
		
		Student temp = SM.SearchData(stuNum);	// Manager Ŭ�������� ã���� �й� �Ѱ��ְ� ��ü ����		
		
		if(temp != null)	// ã���� �ش� ��ü�� ������
		{
			System.out.println("�̸�: " + temp.name );
			System.out.println("��ȭ��ȣ: " + temp.phone);
			System.out.println();
		}
		else // ��ã���� null ����
		{
			System.out.println("�ش� ������ ����. \n");

		}		
	}	
}



public class StudentMainTUI {
	public static void main(String[] args) {
		
		StudentUI UI = new StudentUI();		// UI ����
		UI.ShowMenu();						// �ؽ�Ʈ �޴� �������ִ� �޼ҵ� ����
	}
}
