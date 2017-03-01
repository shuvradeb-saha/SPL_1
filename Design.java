package textEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Design {

	private static JFrame frame = new JFrame("File Chooser");
	private static JTextPane pan = new JTextPane();
	private static JButton btn1 = new JButton("ফাইল");
	private static JMenuBar mnbr = new JMenuBar();
	
	private static JMenuItem newItem, openItem, saveItem, searchItem,replaceItem,fi3,fi4,fi5;
	
	private static JMenu editMenu = new JMenu("সম্পাদন করুন   ।");
	private static JMenu ext = new JMenu("বাহির হউন");
	private static JMenu fileMenu = new JMenu("ফাইল   ।");
	
	public Design() {
		view();
	}

	public void view() {
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setSize(300, 300);
		// int fontSize =
		Font font = new Font("Shonar Bangla", Font.PLAIN, 18);
		
		btn1.setFont(font);
		fileMenu.setFont(font);
		editMenu.setFont(font);
		ext.setFont(font);
		
		JScrollPane scroll = new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pan.setFont(font);

		newItem = new JMenuItem("নতুন");
		openItem = new JMenuItem("খুলুন");
		saveItem = new JMenuItem("সংরক্ষণ");
		
		searchItem = new JMenuItem("সন্ধান ");
		replaceItem = new JMenuItem("প্রতিস্থাপন");
		fi3 = new JMenuItem("কাটুন");
		fi4 = new JMenuItem("কপি");
		fi5 = new JMenuItem("পেস্ট");
		
		

		newItem.setFont(font);
		openItem.setFont(font);
		saveItem.setFont(font);
		searchItem.setFont(font);
		replaceItem.setFont(font);
		fi3.setFont(font);
		fi4.setFont(font);
		fi5.setFont(font);

		fileMenu.add(newItem);
		fileMenu.addSeparator();
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		fileMenu.add(saveItem);

		
		
		editMenu.add(searchItem);
		editMenu.addSeparator();
		editMenu.add(replaceItem);
		editMenu.addSeparator();
		editMenu.add(fi3);
		editMenu.addSeparator();
		editMenu.add(fi4);
		editMenu.addSeparator();
		editMenu.add(fi5);
		
		//>>>>>>>>>>>>>add to main menubar
		
		mnbr.add(fileMenu);
		mnbr.add(editMenu);
		mnbr.add(ext);
		mnbr.setPreferredSize(new Dimension(30, 40));// >>>>> give size

		//>>>>>>>>>>>>>add to main frame
		
		frame.add(mnbr, BorderLayout.BEFORE_FIRST_LINE);
		frame.add(scroll, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
