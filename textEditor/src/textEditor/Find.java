package textEditor;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Find {
	private JFrame findFrame = new JFrame("সন্ধান");
	private JTextField findThis = new JTextField();
	private JLabel fLabel = new JLabel("লিখুন    ");
	private JButton findBtn = new JButton("সন্ধান");
	private JButton findNxtBtn = new JButton("সন্ধান পরবর্তী");
	private JButton exitBtn = new JButton("বাহির");

	public Find(JTextComponent text) {
		// TODO Auto-generated constructor stub
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		Font font = new Font("Siyam Rupali", Font.PLAIN, 14);

		findFrame.setLayout(new GridLayout(2, 1));
		BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
		BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
		panel1.setLayout(layout1);
		panel2.setLayout(layout2);

		panel1.setBorder(BorderFactory.createEtchedBorder());
		panel2.setBorder(BorderFactory.createEtchedBorder());

		findFrame.setFont(font);
		findThis.setFont(font);
		fLabel.setFont(font);
		findBtn.setFont(font);
		findNxtBtn.setFont(font);
		exitBtn.setFont(font);

		// add panel 1
		panel1.add(fLabel);
		panel1.add(findThis);

		// add panel 2
		panel2.add(findBtn);
		panel2.add(findNxtBtn);
		panel2.add(exitBtn);

		findFrame.add(panel1);
		findFrame.add(panel2);

		findFrame.setSize(300, 100);
		findFrame.setResizable(false);
		findFrame.setVisible(true);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>action listener for findbtn
		findBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String pattern = findThis.getText();
				find(text, pattern);

			}
		});
		
		
		
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>action for exit
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				findFrame.setVisible(false);

			}
		});

	}

	public void find(JTextComponent text, String pattern) {
		int start = text.getText().indexOf(findThis.getText());
		if (start == -1) {
			JOptionPane.showMessageDialog(null, "Could not find " + findThis.getText());
			return ;
		}
		int end = start + findThis.getText().length();
		text.select(start, end);
		return ;
	}
}
