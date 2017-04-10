package textEditor;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class About extends JFrame {
	private JTextArea area = new JTextArea();
	public About() {
		setTitle("সম্বন্ধ");
		Font font = new Font("Siyam Rupali", Font.PLAIN, 14);
		area.setFont(font);
		area.setText("বাংলা টেক্সট ইডিটর \n");
		area.append("সফটওয়্যার প্রজেক্ট ল্যাব -১\nশুভ্রদেব সাহা\nআই আই টি ,ঢাকা বিশ্ববিদ্যালয়");
		add(area);
		area.setEditable(false);
		setVisible(true);
		setSize(300, 150);
		setResizable(false);

	}

}
