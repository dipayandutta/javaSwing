import java.awt.BorderLayout;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

public class TestChild extends JFrame{
	
	JFrame frame;
	JPanel panel;
	JTable table;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url  	  = "jdbc:mysql://localhost:3306/loginjava";
	String username	  = "root";
	String password   = "node";
	String[] ColumnNames  = {"RollNo","Name","class","Section"};
	
	public void showResult(String value){
		
		//System.out.println("Got "+value);
		frame = new JFrame("Child Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(ColumnNames);
		
		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);	
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		String textvalue = value;
		String roll      = "";
		String name 	 = "";
		String cl 		 = "";
		String sec 		 = "";
		
		try{
			Class.forName(driverName);
			java.sql.Connection conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from student where rollno = "+textvalue;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			int i = 0;
			
			if (rs.next()){
				roll = rs.getString("rollno");
				name = rs.getString("name");
				cl   = rs.getString("class");
				sec  = rs.getString("section");
				model.addRow(new Object[]{roll,name,cl,sec});
				i++;
			}
			if (i<1){
				JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
			}
			if (i==1){
				System.out.println("Only One Record Found!");
			}
			else{
				System.out.println(i+"Record Found");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		frame.add(scroll);
		frame.setVisible(true);
		frame.setSize(400, 400);
	}

}
