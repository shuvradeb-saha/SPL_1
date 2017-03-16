package textEditor;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;

public class Find {
	private JFrame findFrame = new JFrame("সন্ধান");
	private JTextField findThis = new JTextField();
	private JLabel fLabel = new JLabel("লিখুন  ");
	private JButton findBtn = new JButton("সন্ধান");
	private JButton findAllBtn = new JButton("সন্ধান সব");
	private JButton exitBtn = new JButton("বাহির");

	public Find(JTextPane textPan) {

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		Font font = new Font("Siyam Rupali", Font.PLAIN, 14);

		// >>>layout manage
		findFrame.setLayout(new GridLayout(2, 1));
		BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
		BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);

		panel1.setLayout(layout1);
		panel2.setLayout(layout2);

		panel1.setBorder(BorderFactory.createEtchedBorder());
		panel2.setBorder(BorderFactory.createEtchedBorder());

		// >>>>>>>>>>setFont.....
		findFrame.setFont(font);
		findThis.setFont(font);
		fLabel.setFont(font);
		findBtn.setFont(font);
		findAllBtn.setFont(font);
		exitBtn.setFont(font);

		// .>>>>>>>>set alignment
		fLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		findThis.setAlignmentX(Component.RIGHT_ALIGNMENT);
		findBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
		findAllBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
		exitBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);

		// add panel 1
		panel1.add(fLabel);
		panel1.add(findThis);

		// add panel 2
		panel2.add(findBtn);
		panel2.add(findAllBtn);
		panel2.add(exitBtn);

		// >>>>>>>>>>>>>>>>>>>>>>>>>>action listener for findbtn
		findBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String pattern = findThis.getText();
				// String text = textPan.getText();
				removeHighlights(textPan);
				find(textPan, pattern);

			}
		});

		// >>>>>>>>>>>>>>>>>>>>>>>>>>action for exit
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeHighlights(textPan);

				findFrame.setVisible(false);

			}
		});

		// add panel to frame
		findFrame.add(panel1);
		findFrame.add(panel2);
		findFrame.setSize(400, 100);
		findFrame.setResizable(false);
		findFrame.setVisible(true);

	}

	public void find(JTextPane textPan, String pattern) {
		String text = textPan.getText();
		int pos = text.indexOf(pattern);
		if (pos == -1)
			JOptionPane.showMessageDialog(null, "not found");
		else {
			// JOptionPane.showMessageDialog(null, "found");
			Highlighter.HighlightPainter myHighlighter = new MyHighlighter(Color.LIGHT_GRAY);
			Highlighter hilite = textPan.getHighlighter();
			try {
				hilite.addHighlight(pos, pos + pattern.length(), myHighlighter);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void removeHighlights(JTextPane textComp) {
		Highlighter hilite = textComp.getHighlighter();
		Highlighter.Highlight[] hilites = hilite.getHighlights();

		for (int i = 0; i < hilites.length; i++) {
			if (hilites[i].getPainter() instanceof MyHighlighter) {
				hilite.removeHighlight(hilites[i]);
			}
		}
	}

}
