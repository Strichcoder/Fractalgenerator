import java.awt.Graphics2D;


public class Fragment {

	private Point p1;
	private Point p2;
	
	public Fragment(Point p1, Point p2){
		this.p1=p1;
		this.p2=p2;
	}
	
	public void draw(Graphics2D g)
	{
		g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		p1.draw(g);
		p2.draw(g);
	}
	
	public void setP1(Point p)
	{
		this.p1 = p;
	}
	
	public void setP2(Point p)
	{
		this.p2 = p;
	}
	
	public Point getP1()
	{
		return p1;
	}
	
	public Point getP2()
	{
		return p2;
	}
	
}
