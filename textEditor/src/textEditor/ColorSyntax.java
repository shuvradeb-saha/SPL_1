package textEditor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class ColorSyntax{
	
	public static final Color DEFAULT_KEYWORD_COLOR1 = Color.BLUE;
	public static final Color DEFAULT_KEYWORD_COLOR2 = Color.RED;
	public static final Color DEFAULT_KEYWORD_COLOR3 = Color.GREEN;

	public static final String[] JAVA_KEYWORDS = new String[] { "ধরি", "যদি", "নাহলে যদি", "নাহলে", "এবং", "অথবা",
			"সত্য", "মিথ্যা", "হ্যা", "না", "লুপ", "চলবে", "থামো", "নাল", "ফাংশন", "রিটার্ন", "অসীম", "_ইন্ডেক্স" };;

	public static String JAVA_KEYWORDS_REGEX;

	static {
		StringBuilder buff = new StringBuilder("");
		buff.append("(");
		for (String keyword : JAVA_KEYWORDS) {
			buff.append("\\b").append(keyword).append("\\b").append("|");
		}
		buff.deleteCharAt(buff.length() - 1); // last er | eta kete dibe
		buff.append(")");
		JAVA_KEYWORDS_REGEX = buff.toString();
	}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public static final String[] KEYWORDS2 = new String[] { "এর", "বার", "হয়", "পায়", "থাকে", "হতে", "থেকে", "চেয়ে",
			"মান", "সমান", "ছোট", "বড়", "কম", "বেশি", "দেখতে", "শুনতে", "বলতে ", "বুঝতে" };
	public static String KEYWORDS2_REGEX;

	static {
		StringBuilder buff = new StringBuilder("");
		buff.append("(");
		for (String keyword : KEYWORDS2) {
			buff.append("\\b").append(keyword).append("\\b").append("|");
		}
		buff.deleteCharAt(buff.length() - 1);
		buff.append(")");
		KEYWORDS2_REGEX = buff.toString();
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public static final String[] KEYWORDS3 = new String[] { "দেখাও", "ইনপুট", "_টাইপ", "_বর্গমূল", "_নাম্বার",
			"_পূর্ণসংখ্যা", "_সময়", "_পাই" };
	public static String KEYWORDS3_REGEX;

	static {
		StringBuilder buff = new StringBuilder("");
		buff.append("(");
		for (String keyword : KEYWORDS3) {
			buff.append("\\b").append(keyword).append("\\b").append("|");
		}
		buff.deleteCharAt(buff.length() - 1);
		buff.append(")");
		KEYWORDS3_REGEX = buff.toString();
	}

	private StyledDocument textEditorDoc;

	public ColorSyntax(JTextPane textEditor) {
		//JTextPane textEditor = textEditor1;
		
		textEditorDoc = textEditor.getStyledDocument();
		textEditor.getDocument().putProperty(
				DefaultEditorKit.EndOfLineStringProperty, "\n");
	
	
	Pattern pattern = Pattern.compile(JAVA_KEYWORDS_REGEX,Pattern.UNICODE_CHARACTER_CLASS);
	Pattern pattern2 = Pattern.compile(KEYWORDS2_REGEX,Pattern.UNICODE_CHARACTER_CLASS);
	Pattern pattern3 = Pattern.compile(KEYWORDS3_REGEX,Pattern.UNICODE_CHARACTER_CLASS);
	textEditor.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
				clearTextColors(textEditor);
				Matcher match = pattern.matcher(textEditor.getText());
				if(match != null){
				while (match.find()) {
					updateTextColor(match.start(), match.end() - match.start());
					}
				}
				Matcher match2 = pattern2.matcher(textEditor.getText());
				if(match2 != null ){
				while (match2.find()) {
					updateTextColor2(match2.start(), match2.end() - match2.start());
					}
				}
				
				Matcher match3 = pattern3.matcher(textEditor.getText());
				if(match3 != null ){
				while (match3.find()) {
					updateTextColor3(match3.start(), match3.end() - match3.start());
					}
				}
			
		}
	});
}

	public void updateTextColor(int offset, int length, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
		textEditorDoc.setCharacterAttributes(offset, length, aset, true);
	}

	public void clearTextColors(JTextPane textEditor) {
		updateTextColor(0, textEditor.getText().length(), Color.BLACK);
	}

	public void updateTextColor(int offset, int length) {
		updateTextColor(offset, length, DEFAULT_KEYWORD_COLOR1);
	}

	public void updateTextColor2(int offset, int length) {
		updateTextColor(offset, length, DEFAULT_KEYWORD_COLOR2);
	}

	public void updateTextColor3(int offset, int length) {
		updateTextColor(offset, length, DEFAULT_KEYWORD_COLOR3);
	}
}
