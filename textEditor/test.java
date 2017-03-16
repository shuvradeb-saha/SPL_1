package textEditor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class test extends JFrame{
	public test(){
		//JTextPane jp = new JTextPane();
		//add(jp,BorderLayout.CENTER);
		String text = "আমার সোনার বাংলা আমি তোমায় ভালবাসি";	
		String pat = "jk";
		int pos =0;
		pos=text.indexOf(pat,pos);
		System.out.println(pos);
		
		//setvisible(true);
	}
	public static void main(String[] args) {
		new test();
	}
}
