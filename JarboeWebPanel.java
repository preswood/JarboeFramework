package jarboe;

import java.awt.Color;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class JarboeWebPanel extends JarboePanel
{
	private static final long serialVersionUID = 1L; //default serial ID added due to issues with some compilers
	public JarboeWebPanel(String URL)
	{
		JScrollPane scrollPanel = new JScrollPane();
		JEditorPane editorPanel = new JEditorPane();
		editorPanel.setEditable(false);
		scrollPanel.setViewportView(editorPanel);
		add(scrollPanel);
		try {
			editorPanel.setPage(new URL(URL));
		} catch (Exception e) { e.printStackTrace(); setForeground(Color.orange);} //orange will stand out so it's easier to spot a page that didn't load
	}
}