import java.awt.Graphics2D;
import java.util.ArrayList;


public class FractalBuilder 
{
	private Point start;
	private Point end;
	private Point input;
	
	private Fragment current;
	
	private ArrayList<Fragment> fragments;
	
	public FractalBuilder(Point start, Point end, Point input)
	{
		this.start = start;
		this.end = end;
		this.input = input;
		current = new Fragment(start, input);
		fragments = new ArrayList<Fragment>();
		fragments.add(current);
	}
	
	public void addFragment(Point p)
	{
		if(p.abs(end) < Point.getgRadius()) // clicked on the end Point
		{
			current.setP2(end);
		}
		else
		{
		current.setP2(p);
		current = new Fragment(p,input);
		fragments.add(current);
		}
	}
	
	public void draw(Graphics2D g)
	{
		for(int i=0;i<fragments.size();i++)
		{
			fragments.get(i).draw(g);
		}
		start.draw(g);
		end.draw(g);
		input.draw(g);
	}
	

	public Fractal toFractal()
	{
		ArrayList<Pointd> fractallist = new ArrayList<Pointd>();
		fractallist.add(fractalize(start));
		for(int i=0;i<fragments.size();i++)
		{
			fractallist.add(fractalize(fragments.get(i).getP2()));
		}
		return new Fractal(fractallist);
	}
	
	private Pointd fractalize(Point p)
	{
		double dy = 	end.getX()*p.getY() - end.getX()*start.getY()
						- start.getX()*p.getY() - end.getY()*p.getX() 
						+ end.getY()*start.getX() + start.getY()*p.getX();
		dy=dy/((start.getY()-end.getY())*(start.getY()-end.getY())+(start.getX()-end.getX())*(start.getX()-end.getX()));
		double dx = (p.getX()-start.getX()-dy*(start.getY()-end.getY()))/(end.getX()-start.getX());
		return new Pointd(dx,dy);
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public Point getInput() {
		return input;
	}

	public void setInput(Point input) {
		this.input = input;
	}
	
	
	
}
