package textEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Design {

	public static JFrame frame = new JFrame("বাংলা টেক্সট ইডিটর");
	private static JTextPane pan = new JTextPane();
	private static JMenuBar mnbr = new JMenuBar();
	private static JMenuItem newItem, openItem, saveItem, searchItem, replaceItem, cutItem, copyItem, pasteItem,
			aboutItem, fontSize, fontStyle;
	private static JMenu editMenu = new JMenu("সম্পাদন করুন   ।");
	private static JMenu about = new JMenu("সম্বন্ধ");
	private static JMenu fontMenu = new JMenu("ফন্ট    ।");
	private static JMenuItem ext = new JMenuItem("বাহির হউন");
	private static JMenu fileMenu = new JMenu("ফাইল   ।");
	public static int fSize = 14;
	public static String fStyle = "Siyam Rupali";

	public Design() {
		view();
	}

	public void view() {
		// ColorSyntax();
		mnbr.setBackground(Color.lightGray);
		frame.getContentPane().setLayout(new BorderLayout());
		Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setMaximumSize(DimMax);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(300, 300));

		Font font = new Font("Siyam Rupali", Font.PLAIN, 14);

		Font fontForText = new Font(fStyle, 2, fSize);
		// Font font = new Font("SutonnyMJ", Font., 18);

		JScrollPane scroll = new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		newItem = new JMenuItem("নতুন");
		openItem = new JMenuItem("খুলুন");
		saveItem = new JMenuItem("সংরক্ষণ");
		searchItem = new JMenuItem("সন্ধান ");
		replaceItem = new JMenuItem("প্রতিস্থাপন");
		cutItem = new JMenuItem();
		copyItem = new JMenuItem();
		pasteItem = new JMenuItem();
		aboutItem = new JMenuItem("ইডিটর সম্বন্ধে জানুন");
		fontSize = new JMenuItem("আকার");
		fontStyle = new JMenuItem("ধরন");

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>set font for the contents

		fileMenu.setFont(font);
		editMenu.setFont(font);
		about.setFont(font);
		ext.setFont(font);
		pan.setFont(fontForText);
		newItem.setFont(font);
		openItem.setFont(font);
		saveItem.setFont(font);
		searchItem.setFont(font);
		replaceItem.setFont(font);
		cutItem.setFont(font);
		copyItem.setFont(font);
		pasteItem.setFont(font);
		aboutItem.setFont(font);
		fontMenu.setFont(font);
		fontSize.setFont(font);
		fontStyle.setFont(font);

		// >>>>>>>>>>>>>>>>>>>>>>>>>add fileMenu item

		fileMenu.add(newItem);
		fileMenu.addSeparator();
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(ext);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>> add to about menu
		about.add(aboutItem);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>add editMenu
		editMenu.add(searchItem);
		editMenu.addSeparator();
		editMenu.add(replaceItem);
		editMenu.addSeparator();
		editMenu.add(cutItem);
		editMenu.addSeparator();
		editMenu.add(copyItem);
		editMenu.addSeparator();
		editMenu.add(pasteItem);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>> add to font menu
		fontMenu.add(fontSize);
		fontMenu.add(fontStyle);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>add to main menu bar
		mnbr.add(fileMenu);
		mnbr.add(editMenu);
		mnbr.add(fontMenu);
		mnbr.add(about);
		mnbr.setPreferredSize(new Dimension(50, 60)); // >>>>> give size

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>add to main frame

		frame.add(mnbr, BorderLayout.BEFORE_FIRST_LINE);
		frame.add(scroll, BorderLayout.CENTER);
		frame.setVisible(true);

		pan.setBackground(Color.LIGHT_GRAY);
		
		//>>>>>>>>>>>>>>cut ,copy ,paste
		cutItem.setAction(new DefaultEditorKit.CutAction());
		cutItem.setText("কাটুন");
		
		copyItem.setAction(new DefaultEditorKit.CopyAction());
		copyItem.setText("কপি");
		
		pasteItem.setAction(new DefaultEditorKit.PasteAction());
		pasteItem.setText("পেস্ট");
		
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>action listener for menu save item

		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChoose = new JFileChooser();
				int option = fileChoose.showSaveDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
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
				frame.setTitle("Untitled |");
				pan.setText("");
				// new EditorMain();

			}

		});

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>action listener for menu open item

		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan.setText("");
				JFileChooser fileChoose = new JFileChooser();
				int option = fileChoose.showOpenDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					try {
						File file = fileChoose.getSelectedFile();
						frame.setTitle(file.getName() + " | ");
						FileInputStream myFile = new FileInputStream(file.getPath());
						BufferedReader br = new BufferedReader(new InputStreamReader(myFile, "UTF-8"));
						try {
							pan.read(br, null);
							br.close();
						} catch (IOException e2) {
							e2.printStackTrace();
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
				
				//frame.setVisible(false);
				frame.dispose();

			}
		});

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>search item action
		searchItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Find(pan);

			}
		});

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>search and replace action
		replaceItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindAndReplace(pan);
			}
		});
		
		
		// >>>>>>>>>>>>>>>>>>>>>>>>aboutItem action
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new About();
			}
		});

		// >>>>>>>>>>>>>>>>>>>>fontSize ...................
		fontSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		keyPressed();

	}
	
	// >>>>>>>>>>>>>>>>>>>>>> keylistener
	public void keyPressed(){
		try{
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		ext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		searchItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		replaceItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}