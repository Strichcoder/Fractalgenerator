import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Input implements MouseListener, MouseMotionListener{

	public static boolean LEFT;
	public static boolean RIGHT;
	public static Point point;
	private static boolean leftclicked;
	private static boolean rightclicked;
	
		public Input()
		{
			LEFT = false;
			RIGHT = false;
			point = new Point(1,1);
		}
	
		public static boolean clicked(int VM) // VM = virtual Mouse
		{
			if(VM==1 && leftclicked)
			{
				leftclicked = false;
				return true;
			}
			else if(VM==3 && rightclicked)
			{
				rightclicked = false;
				return true;
			}
			return false;
		}
		
		// MOUSE
		
		@Override
		public void mousePressed(MouseEvent e){
			if(e.getButton()==1)
			{
				LEFT = true;
				leftclicked = true;
			}
			if(e.getButton()==3)
			{
				RIGHT = true;
				rightclicked = true;
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e){
			if(e.getButton()==1)
			{
				LEFT = false;
				leftclicked = false;
			}
			if(e.getButton()==3)
			{
				RIGHT = false;
				rightclicked = false;
			}
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			point.setX(e.getX());
			point.setY(e.getY());
		}
		
		public int mouseX()
		{
		     return (int)MouseInfo.getPointerInfo().getLocation().getX();
		}
		public int mouseY()
		{
		     return (int)MouseInfo.getPointerInfo().getLocation().getY();
		}
		
		// MOUSE UNUSED
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e)
		{       
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public static Point getPoint() {
			return point;
		}

		
}


