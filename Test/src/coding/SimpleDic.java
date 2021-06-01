package coding;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDic extends JPanel implements ActionListener{
	
	private JTextField inputField =new JTextField(30);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn =new JButton("추가");
	
	private Map<String, String> dictMap = new HashMap<>();
	private static final String DIC_FILE_NAME="dict.props";
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/oop";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "1234";
	
	public SimpleDic() {
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		this.setPreferredSize(new Dimension(600,50));	
		//JDBC 드라이버 메모리 적재하기
		//JDBC 클래스 이름은 DB마다 다름
		try {		
			Class.forName("org.mariadb.jdbc.Driver");
			buildDictionaryFromDB();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//buildDictionaryFromFile();
	}
	//dictionary 초기화 
	private void buildDictionaryFromDB() {
		try(Connection con = 
				DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
			String sql = "select * from dict";
			//준비완료된 객체
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String key = rs.getString("word1");
				String value = rs.getString("word2");
				dictMap.put(key,value);
				System.out.println(key+" : "+value);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	private void buildDictionaryFromFile(){
		Properties props = new Properties();
		try(FileReader fReader = new FileReader(DIC_FILE_NAME)){
			props.load(fReader);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Set<Object> set = props.keySet();
		for(Object key : set) {
			Object value = props.get(key);
			dictMap.put((String)key,(String)value);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		String value =dictMap.get(key);
		if(e.getSource() == searchBtn) {
			if(value==null)
			JOptionPane.showMessageDialog(this,"단어를 찾을수 없습니다",key,JOptionPane.ERROR_MESSAGE);
			else {
				JOptionPane.showMessageDialog(this,value,key,JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (e.getSource() ==addBtn) {
			String Value = JOptionPane.showInputDialog(this, key +" 에 대응되는 영어단어를 입력하세요");
			System.out.println(key+value);
			if(Value.trim().length() == 0) return;
			dictMap.put(key, Value);
			dictMap.put( Value,key);
			//addWordToFile(key,Value);
				addWordToDB(key,Value);
			JOptionPane.showMessageDialog(this, "영어단어 추가 되었습니다","성공",JOptionPane.INFORMATION_MESSAGE);
			
		
		}
		inputField.requestFocus();
	
	}
	private void addWordToDB(String key, String value) {
		/*
		 *  드라이버를 메모리에 적재한다 <- 메모리 적재는 한번만 하면되고,
		 *  이미 생성자에서 했음.
		 *  DB에 연결해서 Connection 객체를 반환 받는다
		 *	PreparedStatement 객체의 executeUpdate()
		 * 	호출해서 DB에 저장한다.
		 * */
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD)){
			String sql = "insert into dict values(?,?)";
			//실행 준비 
			// 1. 문법 검사
			// 2. 정당성 검사(테이블,칼럼등이 실제로 있는지 , 있다면 사용자가 삽입할 권한이 있는지 체크)
 			PreparedStatement pstmt = con.prepareStatement(sql);
 			// ? 자리의 칼럼 데이터 타입에 따라 
 			// 적절한 setXXX() 메서드를 호출해야한다.
 			// 예를 들어, 칼럼이 char 또는 varchar 타입이면 setString()
 			// 칼럼이 TimeStamp면 setDate(),setTimestamp(),
 			// 칼럼이 int 타입이면 setInt()...
 			pstmt.setString(1, key);
 			pstmt.setString(2, value);
 			
 			pstmt.executeUpdate();	
 			pstmt.setString(1, value);
 			pstmt.setString(2, key);
 			
 			pstmt.executeUpdate();
 			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	private void addWordToFile(String key,String value) {
		try(FileWriter fWriter = new FileWriter(DIC_FILE_NAME)){
			String str = key+"="+value+"\n";
			fWriter.write(str);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		};
	}				
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.add(new SimpleDic());
		frame.setTitle("나의 한영사전");
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	
	
	
	
}
