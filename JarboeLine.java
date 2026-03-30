package jarboe;

public class JarboeLine {
	private int X1;
	private int X2;
	private int Y1;
	private int Y2;
	
	public JarboeLine(int X1, int X2, int Y1, int Y2)
	{
		this.setX1(X1);
		this.setX2(X2);
		this.setY1(Y1);
		this.setY2(Y2);
	}

	public int getX1() {
		return X1;
	}

	public void setX1(int x1) {
		X1 = x1;
	}

	public int getX2() {
		return X2;
	}

	public void setX2(int x2) {
		X2 = x2;
	}

	public int getY1() {
		return Y1;
	}

	public void setY1(int y1) {
		Y1 = y1;
	}

	public int getY2() {
		return Y2;
	}

	public void setY2(int y2) {
		Y2 = y2;
	}

	/*public Graphics getG() {
		return G;
	}

	public void setG(Graphics g) {
		G = g;
	}*/
}