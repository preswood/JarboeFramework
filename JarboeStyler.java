package jarboe;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class JarboeStyler {
	static Font f = new Font("Segoe UI", Font.PLAIN, 12);
	static Color c = new Color(255, 255, 255);	//WHITE
	static Color b = new Color(95, 95, 95);		//INACTIVE
	static Color k = new Color(95, 135, 200);	//HOVER
	static Color p = new Color(0, 0, 255);		//CLICKED
	public static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	    	g.drawOval(x, y, width, height);
	    }
	}
	
	//JButton
	public static void MakeCircle(final JButton button) {
		button.setFont(f);
		button.setBackground(c);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setFocusable(true);
		button.setForeground(b);
		button.setBorder(new RoundedBorder(10));
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Color k = new Color(95, 135, 200);
				Stylize(button, k);
			}
			public void mouseExited(MouseEvent e) {
				MakeCircle(button);
			}
			public void mousePressed(MouseEvent e) {
				Stylize(button, p);
			}
			public void mouseReleased(MouseEvent e) {
				Stylize(button, k);
			}
		});
	}
	
	public static void Stylize(JButton button, Color k) {
		button.setFont(f);
		button.setBackground(c);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setFocusable(true);
		button.setForeground(k);
		button.setBorder(new RoundedBorder(10));
	}
	
	//JTextField
		public static void MakeCircle(JTextField x) {
			x.setFont(f);
			x.setBackground(c);
			//x.setContentAreaFilled(false);
			//x.setFocusPainted(false);
			x.setFocusable(true);
			x.setForeground(b);
			x.setBorder(new RoundedBorder(10));
		}
		
		public static void MakeCircle(JTextField x, Color c) {
			x.setFont(f);
			x.setBackground(c);
			//x.setContentAreaFilled(false);
			//x.setFocusPainted(false);
			x.setFocusable(true);
			x.setForeground(b);
			x.setBorder(new RoundedBorder(10));
		}
		
		public static void Stylize(JTextField x) {
			x.setFont(f);
			x.setBackground(c);
			//button.setContentAreaFilled(false);
			//button.setFocusPainted(false);
			x.setFocusable(true);
			x.setForeground(b);
			x.setBorder(new RoundedBorder(10));
		}
		
		public static void Stylize(JTextField  x, Color k) {
			x.setFont(f);
			x.setBackground(c);
			//x.setContentAreaFilled(false);
			//x.setFocusPainted(false);
			x.setFocusable(true);
			x.setForeground(k);
			x.setBorder(new RoundedBorder(10));
		}
		
		//JPanel
		public static void MakeCircle(JPanel x) {
			x.setFont(f);
			x.setBackground(c);
			//x.setContentAreaFilled(false);
			//x.setFocusPainted(false);
			x.setFocusable(true);
			x.setForeground(b);
			x.setBorder(new RoundedBorder(10));
		}
				
		public static void Stylize(JPanel x) {
			x.setFont(f);
			x.setBackground(c);
			//button.setContentAreaFilled(false);
			//button.setFocusPainted(false);
			x.setFocusable(true);
			x.setForeground(b);
			x.setBorder(new RoundedBorder(10));
		}
				
		public static void Stylize(JPanel x, Color k) {
			x.setFont(f);
			x.setBackground(c);
			//x.setContentAreaFilled(false);
			//x.setFocusPainted(false);
			x.setFocusable(true);
			x.setForeground(k);
			x.setBorder(new RoundedBorder(10));
		}
	
		//DRAWING LINE
		public static void DrawLine(JPanel A, JPanel B) {
			int X1 = A.getX() + (A.getWidth()/2);
			int Y1 = A.getY() + (A.getHeight()/2);
			int X2 = B.getX() + (B.getWidth()/2);
			int Y2 = B.getY() + (B.getHeight()/2);
			A.getGraphics().drawLine(X1, Y1, X2, Y2);
		}
		
		public static void DrawLine(int X1, int Y1, int X2, int Y2) {
			new JPanel().getGraphics().drawLine(X1, Y1, X2, Y2); //new JPanel is a fix to maintain compatibility with previous Jarboe users
		}
}
