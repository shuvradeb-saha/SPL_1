package textEditor;

import java.awt.Color;

import javax.swing.text.DefaultHighlighter;

class MyHighlighter extends DefaultHighlighter.DefaultHighlightPainter {
    public MyHighlighter(Color color) {
        super(color);
    }
}