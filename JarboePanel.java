package jarboe;

import java.awt.Graphics;

import javax.swing.JPanel;


public class JarboePanel extends JPanel {
	private static final long serialVersionUID = 1L; //default serial ID, added due to some compilers having trouble without it
	int X1, X2, Y1, Y2;
	JarboeLine J=null;
	JarboeLine[] JJ=null;
	
	public JarboePanel()
	{
		super();
	}
	
	public JarboePanel(int x1, int y1, int x2, int y2) {
		super();
		X1=x1;
		Y1=y1;
		X2=x2;
		Y2=y2;
	}
	    
	public JarboePanel(JarboeLine j) {
		super();
		J = j;
	}
	
	public JarboePanel(JarboeLine[] jarboeLines) {
		super();
		JJ = jarboeLines;
	}

	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (J != null)
	    {
	    	g.drawLine(J.getX1(), J.getY1(), J.getX2(), J.getY2());
	    } else if (JJ != null) {
	    	for (int i = 0; i < JJ.length; i++)
	    	{
	    		g.drawLine(JJ[i].getX1(), JJ[i].getY1(), JJ[i].getX2(), JJ[i].getY2());
	    	}
	    }
	    
	}
}