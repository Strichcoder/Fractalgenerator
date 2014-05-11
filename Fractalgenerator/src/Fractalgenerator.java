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

	public FractalBuilder fractal;
	
	private static final long serialVersionUID = 1L;

	public Fractalgenerator() 
	{
		input = new Input();
		addMouseListener(input);
		addMouseMotionListener(input);
		
		new Thread(this).start();
	}

	private void update() {
		if(Input.clicked(1))
		{
			System.out.println("clicked");
			fractal.addFragment(Input.point.copy());
		}
	}

	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, WIDTH, HEIGHT);
		g2.setColor(Color.red);
		fractal.draw(g2);
		fractal.toFractal().draw(g2,fractal.getStart().toPointd(), fractal.getEnd().toPointd(),1);
	}

	@Override
	public void run() 
	{
		fractal = new FractalBuilder(new Point(50,HEIGHT/2), new Point(200,HEIGHT/2), Input.getPoint());
		
		while (!paused) { // main loop
			//line.setP2(input.point);
			update();
			repaint();
			try {
				Thread.sleep(20L);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Could not sleep");
			}
		}
			/*
			if (inHandler.getKeys()[KeyEvent.VK_F3]) {
				if(!opened){
					opened=true;
					// opens new frame
					JFrame frame = new JFrame();
					frame.setSize(500, 210);
					frame.setLayout(new BorderLayout());
					
					 baos = new ByteArrayOutputStream();
					 PrintStream ps = new PrintStream(baos);
					 old = System.out;
					 System.setOut(ps);
					 textArea1 = new JTextArea();
					 textArea1.setEditable(false);
					 JScrollPane scrollPane = new JScrollPane(textArea1);
					 scrollPane.setPreferredSize(new Dimension(490,170));
					 frame.add(scrollPane, BorderLayout.NORTH);
					 textArea2 = new JTextArea();
					 textArea2.setPreferredSize(new Dimension(440,30));
					 frame.add(textArea2, BorderLayout.CENTER);
					 JButton but = new JButton("Enter");
					 but.setPreferredSize(new Dimension(50,30));
					 frame.add(but,BorderLayout.EAST);
					 frame.setVisible(true);
					 WinListener win = new WinListener();
					 but.addActionListener(win);
					 frame.addWindowListener(win);
					  Action keyAction = new AbstractAction() {
					        /**
							 * 
							 
							private static final long serialVersionUID = 1L;

							@Override
					        public void actionPerformed(ActionEvent ae) {
					            System.out.println(textArea2.getText());
					           if(textArea2.getText().indexOf("/")==0){
					            String str= textArea2.getText().replace("/", "");
					            String[] str2 = str.split(" ");
					            Level.executeCommand(str2);
					            }
					            textArea2.setText("");
					            
					        }
					    };

					 textArea2.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "ENTER key");
				       textArea2.getActionMap().put("ENTER key", keyAction);
					 System.out.println("Started Dev Console");
					  
					   
					 
					 
				}	
			}
			if(baos!=null){
				if(!baos.toString().equals("")){
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				textArea1.append("<"+dateFormat.format(date)+">"+baos.toString());
				baos.reset();
				}
			}
			
		}
*/
	}

    public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	/**
	 * @param args
	 */
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

	public Input getInput() {
		return input;
	}

}
