import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class FractalBuilder 
{
	private Point start;
	private Point end;
	private Point input;
	
	private boolean finished;
	
	private Fragment current; // the moving one
	
	private ArrayList<Fragment> fragments;
	private Color fragmentColor = Color.red;
	
	private Fractal fractal; // demo-fractal with rekMax=3
	private Color fractalColor = new Color(0.5f, 0.5f, 0.5f, 0.7f);
	private int rekPrev = 4; // preview of fractal. default = 3.
	private int rekMax = 7; // for finished fractals
	
	public FractalBuilder(Point start, Point end, Point input)
	{
		finished = false;
		this.start = start;
		this.end = end;
		this.input = input;
		current = new Fragment(start, input);
		fragments = new ArrayList<Fragment>();
		fragments.add(current);
		fractal = this.toFractal(rekPrev);
	}
	
	public void update()
	{
		if(!finished)
		{
			for(int i=0;i<fragments.size();i++)
			{
				fragments.get(i).getP1().update();
			}
			end.update();
			if(Input.clicked(1))
				addFragment(Input.point.copy());
			if(Input.clicked(3))
				addLastFragment(input);
			fractal.setGenerator(toGenerator()); // update preview
		}
	}
	
	public void draw(Graphics2D g)
	{
		if(finished)
			g.setColor(fragmentColor);
		else
			g.setColor(fractalColor);
		
		fractal.draw(g,getStart().toPointd(), getEnd().toPointd(),1);
		
		if(!finished)
		{
			g.setColor(fragmentColor);
			for(int i=0;i<fragments.size();i++)
			{
				fragments.get(i).draw(g);
			}
			start.draw(g);
			end.draw(g);
			input.draw(g);
		}
	}
	
	// update helpers:
	public void addLastFragment(Point p)
	{
		current.setP2(p);
		fractal.setRekMax(rekMax);
		finished = true;
	}
	
	public void addFragment(Point p) 
	{
		if(p.abs(end) < Point.getgRadius()) // clicked on the end Point
		{
			addLastFragment(end);
		}
		else
		{
		current.setP2(p);
		current = new Fragment(p,input);
		fragments.add(current);
		}
	}
	// end update helpers

	// getters and setters and stuff:
	public ArrayList<Pointd> toGenerator()
	{
		ArrayList<Pointd> fractallist = new ArrayList<Pointd>();
		fractallist.add(fractalize(start));
		for(int i=0;i<fragments.size();i++)
		{
			fractallist.add(fractalize(fragments.get(i).getP2()));
		}
		return fractallist;
	}
	
	public Fractal toFractal(int rek)
	{
		ArrayList<Pointd> fractallist = new ArrayList<Pointd>();
		fractallist.add(fractalize(start));
		for(int i=0;i<fragments.size();i++)
		{
			fractallist.add(fractalize(fragments.get(i).getP2()));
		}
		return new Fractal(fractallist, rek);
	}
	
	private Pointd fractalize(Point p) // used for toFractal()
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
