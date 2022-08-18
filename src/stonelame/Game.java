package stonelame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 480;
	public static int HEIGHT = 480;
	
	public static List<Crab> crabs;
	public static List<Smoke> smoke;
	public Spawner spawner;
	public static Spritesheet spritesheet;
	
	public static Rectangle maskBuraco;
	public static int points=0;
	public static int life=3;
	
	public static double mx,my;
	public static boolean isPressed = false;
	public UI ui;
	public Game() {
		
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.addMouseListener(this);
		spritesheet = new Spritesheet("/spritesheet.png");
		crabs = new ArrayList<>();
		smoke = new ArrayList<>();
		spawner = new Spawner();
		ui = new UI();
		maskBuraco = new Rectangle(WIDTH / 2 - 20, HEIGHT / 2 - 20, 40, 40);
	}
	
	public void update() {
		ui.tick();	
		spawner.update();
		for(int i=0;i < crabs.size();i++) {
			
			crabs.get(i).update();
			
		}
		
		for(int i=0;i < smoke.size();i++) {
			
			smoke.get(i).update();
			
		}
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(255,201,74));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.fillOval(WIDTH / 2 - 20, HEIGHT / 2 - 20, 40, 40);
		for(int i=0;i < crabs.size();i++) {
			
			crabs.get(i).render(g);
			
		}
		for(int i=0;i < smoke.size();i++) {
			
			smoke.get(i).render(g);
			
		}
		ui.render(g);
		g.dispose();
		bs.show();	
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setTitle("Catch the crab");
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		new Thread(game).start();
	}

	@Override
	public void run() {
		double fps = 60.0;
		while(true) {
			
			update();
			render();
			try {
				Thread.sleep((int)(1000/fps));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		isPressed = true;
		
		mx = e.getX();
		my = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
