package textEditor;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class LineNumber {
	private static long ln = 1;

	JPanel panel = new JPanel();

	public LineNumber(JTextPane ar1, JTextArea ar2) {

		ar2.setBackground(Color.lightGray);

		ar2.setText("১" + "\n");
		ar2.setEditable(false);
		ar1.addKeyListener(new KeyListener() {

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

				if (arg0.getKeyCode() == KeyEvent.VK_F5) {
					long lineNum = getLine(ar1);
					ar2.setText("১\n");
					for (int i = 2; i <= lineNum + 1; i++) {
						String eng = Integer.toString(i);
						String num = EngToBan(eng);
						ar2.append(num + "\n");
						ln = lineNum + 1;
					}
				}
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {

					String eng = Integer.toString((int) ++ln);
					String num = EngToBan(eng);
					ar2.append(num + "\n");

				}

			}
		});
		new ColorSyntax(ar1);

	}

	private long getLine(JTextPane ar1) {
		return ar1.getText().split("\n").length;
	}

	private String EngToBan(String eng) {
		String ban = null;
		StringBuilder st = new StringBuilder();
		int len = eng.length();
		for (int i = 0; i < len; i++) {
			char c = eng.charAt(i);
			switch (c) {
			case '0':
				st.append("০");
				break;
			case '1':
				st.append("১");
				break;
			case '2':
				st.append("২");
				break;
			case '3':
				st.append("৩");
				break;
			case '4':
				st.append("৪");
				break;
			case '5':
				st.append("৫");
				break;
			case '6':
				st.append("৬");
				break;
			case '7':
				st.append("৭");
				break;
			case '8':
				st.append("৮");
				break;
			case '9':
				st.append("৯");
				break;
			}
			ban = st.toString();
		}

		return ban;
	}

}
