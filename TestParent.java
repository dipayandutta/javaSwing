import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestParent extends JFrame {
	
	JTextField textbox;
	JLabel label;
	JButton button;
	JFrame frame;
	
	public void createUI(){
		frame = new JFrame("Parent Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		textbox = new JTextField();
		textbox.setBounds(120,30,150,20);
		
		label = new JLabel("Enter The Roll Number");
		label.setBounds(10, 30, 100, 20);
		
		button = new JButton("search");
		button.setBounds(120, 130, 150, 120);
		
		button.addActionListener((ActionEvent event)->{
			//System.out.print("PLayer Renewal Option");
			String textValue = textbox.getText();
			TestChild TC = new TestChild();
			TC.showResult(textValue);
			//System.out.println(textValue);
			
		});
		
		
		frame.add(textbox);
		frame.add(label);
		frame.add(button);
		frame.setVisible(true);
		frame.setSize(500, 500);
	}

	public static void main(String args[]){
			EventQueue.invokeLater(()->{
			
			TestParent tp = new TestParent();
			tp.createUI();
		});
	}

}
