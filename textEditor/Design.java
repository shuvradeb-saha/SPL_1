package textEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

public class Design {

	private static JFrame frame = new JFrame("বাংলা টেক্সট ইডিটর");
	private static JTextPane pan = new JTextPane();
	private static JMenuBar mnbr = new JMenuBar();
	private static JMenuItem newItem, openItem, saveItem, searchItem, replaceItem, cutItem, copyItem, pasteItem,
			aboutItem;
	private static JMenu editMenu = new JMenu("সম্পাদন করুন   ।");
	private static JMenu about = new JMenu("সম্বন্ধ");
	private static JMenuItem ext = new JMenuItem("বাহির হউন");
	private static JMenu fileMenu = new JMenu("ফাইল   ।");

	public Design() {
		view();
	}

	public void view() {

		frame.getContentPane().setLayout(new BorderLayout());
		Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setMaximumSize(DimMax);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(300, 300));

		// Font font = new Font("Shonar Bangla", Font.PLAIN, 18);
		Font font = new Font("Siyam Rupali", Font.PLAIN, 14);
		// Font font = new Font("SutonnyMJ", Font.PLAIN, 18);

		JScrollPane scroll = new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		newItem = new JMenuItem("নতুন");
		openItem = new JMenuItem("খুলুন");
		saveItem = new JMenuItem("সংরক্ষণ");
		searchItem = new JMenuItem("সন্ধান ");
		replaceItem = new JMenuItem("প্রতিস্থাপন");
		cutItem = new JMenuItem("কাটুন");
		copyItem = new JMenuItem("কপি");
		pasteItem = new JMenuItem("পেস্ট");
		aboutItem = new JMenuItem("ইডিটর সম্বন্ধে জানুন");

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>set font for the contents

		fileMenu.setFont(font);
		editMenu.setFont(font);
		about.setFont(font);
		ext.setFont(font);
		pan.setFont(font);
		newItem.setFont(font);
		openItem.setFont(font);
		saveItem.setFont(font);
		searchItem.setFont(font);
		replaceItem.setFont(font);
		cutItem.setFont(font);
		copyItem.setFont(font);
		pasteItem.setFont(font);
		aboutItem.setFont(font);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>action listener for menu save item

		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChoose = new JFileChooser();
				int option = fileChoose.showSaveDialog(null);
				if (option == fileChoose.APPROVE_OPTION) {
					try {
						File file = fileChoose.getSelectedFile();
						frame.setTitle(file.getName() + " | ");
						FileOutputStream fout = new FileOutputStream(file.getPath());

						BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fout, "UTF-8"));

						out.write(pan.getText());
						out.close();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
			}
		});

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>action listener for menu new item

		newItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pan.setText("");
			}
		});

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>action listener for menu open item

		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan.setText("");
				JFileChooser fileChoose = new JFileChooser();
				int option = fileChoose.showOpenDialog(null);
				if (option == fileChoose.APPROVE_OPTION) {
					try {
						File file = fileChoose.getSelectedFile();
						frame.setTitle(file.getName() + " | ");
						FileInputStream myFile = new FileInputStream(file.getPath());
						BufferedReader br = new BufferedReader(new InputStreamReader(myFile, "UTF-8"));
						try {
							String x;
							while ((x = br.readLine()) != null) {
								 StyledDocument document = (StyledDocument) pan.getDocument();
							     document.insertString(document.getLength(), x+"\n", null);
							}
						} catch (IOException e2) {
							e2.printStackTrace();
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					} catch (FileNotFoundException e1) {
						System.out.println(e1);
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		// >>>>>>>>>>>>>>>>>>>>exit ......
		ext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showConfirmDialog(null, "close");
				System.exit(0);

			}
		});

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>search item action
		searchItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Find(pan);

			}
		});

		// >>>>>>>>>>>>>>>>>>>>>>>>>add fileMenu item

		fileMenu.add(newItem);
		fileMenu.addSeparator();
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(ext);
		about.add(aboutItem);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>add editMenu item

		editMenu.add(searchItem);
		editMenu.addSeparator();
		editMenu.add(replaceItem);
		editMenu.addSeparator();
		editMenu.add(cutItem);
		editMenu.addSeparator();
		editMenu.add(copyItem);
		editMenu.addSeparator();
		editMenu.add(pasteItem);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>add to main menu bar

		mnbr.add(fileMenu);
		mnbr.add(editMenu);
		mnbr.add(about);
		mnbr.setPreferredSize(new Dimension(30, 40)); // >>>>> give size

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>add to main frame

		frame.add(mnbr, BorderLayout.BEFORE_FIRST_LINE);
		frame.add(scroll, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
