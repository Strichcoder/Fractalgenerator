import java.awt.Graphics2D;
import java.util.ArrayList;


public class Fractal {

	private int rekMax = 7;
	private ArrayList<Pointd> points;
	
	public Fractal(ArrayList<Pointd> points)
	{
		this.points = points;
	}
	
	public void draw(Graphics2D g, Pointd p1, Pointd p2, int rek)
	{
		if(rek < rekMax)
		{
			for(int i=0;i<points.size()-1;i++)
			{
				draw(g, vectorAddition(p1, p2, points.get(i)), vectorAddition(p1, p2, points.get(i+1)), rek+1); // not true
			}
		}
		else // finally draw it
		{
			g.drawLine(p1.toPoint().getX(), p1.toPoint().getY(), p2.toPoint().getX(), p2.toPoint().getY());
		}
	}
	
	private Pointd vectorAddition(Pointd p1, Pointd p2, Pointd p)
	{
		Pointd vec = p2.subtract(p1);
		double x=p.getX()*vec.getX()  - p.getY()*vec.getY()   + p1.getX();
		double y=p.getX()*vec.getY()  + p.getY()*vec.getX()   + p1.getY();
		return new Pointd(x,y);
	}

	public int getRekMax() {
		return rekMax;
	}

	public void setRekMax(int rekMax) {
		this.rekMax = rekMax;
	}
	
}
