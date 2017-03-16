package textEditor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FindAndReplace {
	public FindAndReplace(){
		 Font font = new Font("Siyam Rupali", Font.PLAIN, 14);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextField findField = new JTextField();
		JLabel findLabel = new JLabel("সন্ধান করুন");
		
		JTextField rplField = new JTextField();
		JLabel rplLabel = new JLabel("প্রতিস্থাপন করুন");
		
		frame.setLayout(new BorderLayout());
		
		panel.setLayout(new GridLayout(2, 2,40,40));
		
		//findField.setPreferredSize();
		
		findLabel.setFont(font);
		panel.add(findLabel);
		panel.add(findField);
		panel.add(rplLabel);
		panel.add(rplField);
		frame.add(panel,BorderLayout.CENTER);
		frame.setSize(200,200);
		frame.setVisible(true);
				
	}
	
}
