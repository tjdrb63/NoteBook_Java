package coding;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	public SimpleDic() {
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		this.setPreferredSize(new Dimension(600,50));	
		buildDictionaryFromFile();
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
		if(value!=null )
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
			addWordToFile(key,Value);
			JOptionPane.showMessageDialog(this, "����ܾ� �߰� �Ǿ����ϴ�","����",JOptionPane.INFORMATION_MESSAGE);
			
		
		}
		inputField.requestFocus();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		String value =dictMap.get(key);
		if(value!=null )
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
			addWordToFile(key,Value);
			JOptionPane.showMessageDialog(this, "����ܾ� �߰� �Ǿ����ϴ�","����",JOptionPane.INFORMATION_MESSAGE);
			
		
		}
		inputField.requestFocus();
	
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
