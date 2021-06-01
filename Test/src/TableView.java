
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;


public class TableView extends JFrame implements ActionListener{

	private JTextField idField,titleField,publisherField,yearField,priceField;
	private JButton previousBtn,nextBtn,insertBtn,finishBtn;
	private ResultSet rs =null;
	private Connection con = null;
	
	public TableView() {
		/*	
		 * �� ������Ʈ�� frame�� �߰��ϱ�
		 *	TableViewer ��ü�� �����ɋ� DB �� Books ���̺��� 
		 *	���ڵ带 �о�´�.
		 *	1. �����ͺ��̽��� ����
		 *	2. select�� �����ϰ� ��ȯ�� ResultSet ��ü�� �������־����
		 *
		 */
		this.setLayout(new GridLayout(0,2));
		
		this.add(new JLabel("ID",JLabel.CENTER));
		idField = new JTextField(10);
		this.add(idField);
		
		this.add(new JLabel("Title",JLabel.CENTER));
		titleField = new JTextField(10);
		this.add(titleField);

		this.add(new JLabel("Publisher",JLabel.CENTER));
		publisherField = new JTextField(10);
		this.add(publisherField);
		
		this.add(new JLabel("Year",JLabel.CENTER));
		yearField = new JTextField(10);
		this.add(yearField);

		this.add(new JLabel("Price",JLabel.CENTER));
		priceField = new JTextField(10);
		this.add(priceField);
		
		previousBtn = new JButton("Previous");
		previousBtn.addActionListener(this);
		this.add(previousBtn);
		
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(this);
		this.add(insertBtn);

		finishBtn = new JButton("Finish");
		finishBtn.addActionListener(this);
		this.add(finishBtn);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350,200);
		this.setVisible(true);
		
		
		String sql = "Select * From books;";
		
		try {
		Class.forName("org.mariadb.jdbc.Driver"); 
		con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/oop","root","1234");
		PreparedStatement pstmt =  con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("DB ���ῡ ������ �־� ���α׷� �����մϴ�");
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TableView();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== nextBtn || e.getSource() == previousBtn) {
			try {
				if(e.getSource()==nextBtn) rs.next();
				else rs.previous();
				
				int bookid = rs.getInt("book_id");
				idField.setText(String.valueOf(bookid));
				
				String tilte = rs.getString("title");
				titleField.setText(tilte);
				
				String publisher = rs.getString("publisher");
				publisherField.setText(publisher);
				
				int price = rs.getInt("price");
				priceField.setText(String.valueOf(price));
				
				Date year = rs.getDate("year");
				yearField.setText(String.valueOf(year));
				
			} catch (SQLException err) {
				err.printStackTrace();
			}
		}else if (e.getSource() == insertBtn) {
			//DB�� �̹� �����
			//insert  �̿��ؼ� prepare �ϰ� ��ȯ��
			String sql = "insert into books(title,publisher,year,price) values(?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(sql);
				//? �ڸ������Ҷ� varchar = String , int = int ...
				String title = titleField.getText();
				pstmt.setString(1,title);
				
				String publisher = publisherField.getText();
				pstmt.setString(2,publisher);
				
				String year = yearField.getText();
				pstmt.setDate(3,Date.valueOf(year));
				
				String price = priceField.getText();
				pstmt.setInt(4,Integer.parseInt(price));
				
				reloading();
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, "��ϼ���");
				
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "��Ͻ��� " + e1.getMessage());
				
			}
			
		}
	
		
	}
	private void reloading() throws Exception{
		String sql = "select * from books order by book_id DESC";
		PreparedStatement pstmt = con.prepareStatement(sql);
		rs.close();
		rs = pstmt.executeQuery();
	}
}
