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
	private JButton searchBtn = new JButton("�˻�");
	private JButton addBtn =new JButton("�߰�");
	
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
		//JDBC ����̹� �޸� �����ϱ�
		//JDBC Ŭ���� �̸��� DB���� �ٸ�
		try {		
			Class.forName("org.mariadb.jdbc.Driver");
			buildDictionaryFromDB();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//buildDictionaryFromFile();
	}
	//dictionary �ʱ�ȭ 
	private void buildDictionaryFromDB() {
		try(Connection con = 
				DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
			String sql = "select * from dict";
			//�غ�Ϸ�� ��ü
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
			JOptionPane.showMessageDialog(this,"�ܾ ã���� �����ϴ�",key,JOptionPane.ERROR_MESSAGE);
			else {
				JOptionPane.showMessageDialog(this,value,key,JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (e.getSource() ==addBtn) {
			String Value = JOptionPane.showInputDialog(this, key +" �� �����Ǵ� ����ܾ �Է��ϼ���");
			System.out.println(key+value);
			if(Value.trim().length() == 0) return;
			dictMap.put(key, Value);
			dictMap.put( Value,key);
			//addWordToFile(key,Value);
				addWordToDB(key,Value);
			JOptionPane.showMessageDialog(this, "����ܾ� �߰� �Ǿ����ϴ�","����",JOptionPane.INFORMATION_MESSAGE);
			
		
		}
		inputField.requestFocus();
	
	}
	private void addWordToDB(String key, String value) {
		/*
		 *  ����̹��� �޸𸮿� �����Ѵ� <- �޸� ����� �ѹ��� �ϸ�ǰ�,
		 *  �̹� �����ڿ��� ����.
		 *  DB�� �����ؼ� Connection ��ü�� ��ȯ �޴´�
		 *	PreparedStatement ��ü�� executeUpdate()
		 * 	ȣ���ؼ� DB�� �����Ѵ�.
		 * */
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD)){
			String sql = "insert into dict values(?,?)";
			//���� �غ� 
			// 1. ���� �˻�
			// 2. ���缺 �˻�(���̺�,Į������ ������ �ִ��� , �ִٸ� ����ڰ� ������ ������ �ִ��� üũ)
 			PreparedStatement pstmt = con.prepareStatement(sql);
 			// ? �ڸ��� Į�� ������ Ÿ�Կ� ���� 
 			// ������ setXXX() �޼��带 ȣ���ؾ��Ѵ�.
 			// ���� ���, Į���� char �Ǵ� varchar Ÿ���̸� setString()
 			// Į���� TimeStamp�� setDate(),setTimestamp(),
 			// Į���� int Ÿ���̸� setInt()...
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
		frame.setTitle("���� �ѿ�����");
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	
	
	
	
}
