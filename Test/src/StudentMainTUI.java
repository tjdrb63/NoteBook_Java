import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//Entity 클래스
class Student {
	int stuNum;			// 학번
	String name;		// 이름
	String phone;
	
	// 생성자
	public Student(int stuNum, String name, String phone) {
		this.stuNum = stuNum;
		this.name = name;
		this.phone = phone;
	}
}


//Manager 클래스
class StudentManager{
	// Student 저장용 HashMap 생성
	HashMap<Integer, Student> stuMap = new HashMap<Integer, Student>();
	
	// 해당 정보를 받아서 Student 객체를 생성해서 추가하도록 작성함!!!
	public void InputData(int stuNum, String name,  String phone) {	
		Student student = new Student(stuNum, name, phone);
		stuMap.put(stuNum, student);
	}
	
	// 학번 정보를 받아서 찾아보고 있으면 객체 리턴, 못찾으면 null 반환하도록 작성함!!!!
	Student SearchData(int stuNum) {			
		Student result = null;	// 리턴값. 찾으면 찾은 객체를 리턴하고, 못찾으면 null 리턴임
		
		result = stuMap.get(stuNum);
		
		return result; // 못찾으면 null 리턴!!
	}
	
}



//UI 클래스
class StudentUI{	
	
	StudentManager SM = new StudentManager();		// StudentManager 생성
	public Scanner keyboard=new Scanner(System.in);	// 콘솔 입력용
	
	
	// 텍스트 메뉴를 계속 유지해주는 메소드
	void ShowMenu() {
		
		int choice;		// 메뉴 선택용
				
		while(true)
		{
			System.out.println("<< 학생 정보 관리 >>");
			System.out.println("[1] 학생 정보 입력");
			System.out.println("[2] 학생 정보 검색");
			System.out.print("선택: ");
			
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
		System.out.println("<< 학생 정보 입력 >>");
		System.out.print("학번: ");
		int stuNum =keyboard.nextInt();
		
		System.out.print("이름: ");
		String name=keyboard.next();
		
		System.out.print("전화번호: ");
		String phone=keyboard.next();
		
		
		SM.InputData(stuNum, name, phone);		// Manager 클래스에서 입력을 하도록 정보를 넘겨줌		

		System.out.println("입력이 완료 되었습니다. \n");

	}
	
	
	void SearchDataUI()
	{
		System.out.println("<< 학생 정보 검색 >>");
		System.out.print("학번: ");
		int stuNum = keyboard.nextInt();
		
		
		Student temp = SM.SearchData(stuNum);	// Manager 클래스에서 찾도록 학번 넘겨주고 객체 받음		
		
		if(temp != null)	// 찾으면 해당 객체를 가져옴
		{
			System.out.println("이름: " + temp.name );
			System.out.println("전화번호: " + temp.phone);
			System.out.println();
		}
		else // 못찾으면 null 리턴
		{
			System.out.println("해당 데이터 없음. \n");

		}		
	}	
}



public class StudentMainTUI {
	public static void main(String[] args) {
		
		StudentUI UI = new StudentUI();		// UI 생성
		UI.ShowMenu();						// 텍스트 메뉴 유지해주는 메소드 실행
	}
}
