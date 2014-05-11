import java.awt.Color;
import java.awt.Graphics2D;


public class Point 
{
	private int x;
	private int y;
	
	private static int gRadius = 4;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics2D g)
	{
		if((double)abs(Input.point) < gRadius)
			g.setColor(Color.blue);
		g.drawOval(x-gRadius, y-gRadius, 2*gRadius, 2*gRadius);
		g.setColor(Color.red);
	}
	
	// getters and setters an' stuff:

	
	public Point subtract(Point p)
	{
		return new Point(x-p.getX(),y-p.getY());
	}
	
	public double abs(Point p)
	{
		Point temp = this.subtract(p);
		return Math.sqrt(temp.getX()*temp.getX()+temp.getY()*temp.getY());
	}
	
	public Point copy()
	{
		return new Point(getX(),getY());
	}
	
	public Pointd toPointd()
	{
		return new Pointd((double)x, (double)y);
	}
	
	public String toString()
	{
		return "("+getX()+"/"+getY()+")";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getgRadius() {
		return gRadius;
	}

	public static void setgRadius(int gRadius) {
		Point.gRadius = gRadius;
	}
	
	
}
