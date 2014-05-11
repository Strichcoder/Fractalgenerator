import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fractalgenerator extends JPanel implements Runnable
{
	
	public static int WIDTH = 640;
	public static int HEIGHT = 480;
	public static boolean paused = false;
	
	public static Input input;

	public FractalBuilder fractalBuilder;
	
	private static final long serialVersionUID = 1L;

	

	private void update() {
		fractalBuilder.update();
	}

	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, WIDTH, HEIGHT);
		fractalBuilder.draw(g2);
	}

	@Override
	public void run() 
	{
		fractalBuilder = new FractalBuilder(new Point(50,HEIGHT/2), new Point(200,HEIGHT/2), Input.getPoint());
		
		while (!paused) { // main loop
			update();
			repaint();
			try {
				Thread.sleep(20L); // ~<50fps
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Could not sleep");
			}
		}
	}

	// main-stuff
	
    public Fractalgenerator() 
	{
		input = new Input();
		addMouseListener(input);
		addMouseMotionListener(input);
		
		new Thread(this).start();
	}
    
	public static void main(String[] args) {
		// opens new frame		
		
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		// make a new JPanel (this FightClub class) and adds it to the frame
		final Fractalgenerator mainP = new Fractalgenerator();
		frame.add(mainP);
		frame.setVisible(true);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// getters and Setters and stuff

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
	
	public Input getInput() {
		return input;
	}

}
