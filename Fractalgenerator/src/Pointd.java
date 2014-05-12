
public class Pointd {

	double x;
	double y;
	
	public Pointd(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Pointd(int x, int y)
	{
		this.x = (double)x;
		this.y = (double)y;
	}

	// getters and setters an' stuff:
	
	public Point toPoint()
	{
		return new Point((int)x, (int)y);
	}
	
	public String toString()
	{
		return "("+getX()+"/"+getY()+")";
	}

	
	public Pointd subtract(Pointd p)
	{
		return new Pointd(x-p.getX(),y-p.getY());
	}
	
	public double abs(Pointd p)
	{
		Pointd temp = this.subtract(p);
		return Math.sqrt(temp.getX()*temp.getX()+temp.getY()*temp.getY());
	}
	
	public Pointd copy()
	{
		return new Pointd(getX(),getY());
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
