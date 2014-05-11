import java.awt.Graphics2D;
import java.util.ArrayList;


public class Fractal {

	private int rekMax = 3;
	private ArrayList<Pointd> generator;
	
	public Fractal(ArrayList<Pointd> generator)
	{
		this.generator = generator;
	}
	
	public Fractal(ArrayList<Pointd> generator, int rek)
	{
		this.generator = generator;
		this.rekMax = rek;
	}
	
	public void draw(Graphics2D g, Pointd p1, Pointd p2, int rek)
	{
		if(rek < rekMax)
		{
			for(int i=0;i<generator.size()-1;i++)
			{
				draw(g, vectorAddition(p1, p2, generator.get(i)), vectorAddition(p1, p2, generator.get(i+1)), rek+1);
			}
		}
		else // finally draw it
		{
			g.drawLine(p1.toPoint().getX(), p1.toPoint().getY(), p2.toPoint().getX(), p2.toPoint().getY());
		}
	}
	
	private Pointd vectorAddition(Pointd p1, Pointd p2, Pointd p) // belongs to draw()
	{
		Pointd vec = p2.subtract(p1);
		double x=p.getX()*vec.getX()  - p.getY()*vec.getY()   + p1.getX();
		double y=p.getX()*vec.getY()  + p.getY()*vec.getX()   + p1.getY();
		return new Pointd(x,y);
	}
	
	// getters and setters and stuff

	public int getRekMax() {
		return rekMax;
	}

	public void setRekMax(int rekMax) {
		this.rekMax = rekMax;
	}

	public void setGenerator(ArrayList<Pointd> generator) {
		this.generator = generator;
	}
	
}
