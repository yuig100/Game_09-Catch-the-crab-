package stonelame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Crab {

	public double x,y,dx,dy;
	double speed = 2;
	public static BufferedImage[] crabSprite;
	private int frames = 0, maxframes = 15, index = 0, maxindex = 3;
	public static boolean isDeath= false;
	public Crab(int x,int y) {
		
		this.x = x;
		this.y = y;
		double radius = Math.atan2((Game.HEIGHT/2 - 20) - y, (Game.WIDTH / 2 - 20) - x);
		this.dx = Math.cos(radius);
		this.dy = Math.sin(radius);
		crabSprite = new BufferedImage[9];
		
		for(int i=0;i < 9;i++) {
			
			crabSprite[i] = Game.spritesheet.getSprite(0 +(16 * i) , 0);
		
		}
		
	}
	
	public void update() {
		
		x+=(dx * speed);
		y+=(dy * speed);
		if(new Rectangle((int)x,(int)y,40,40).intersects(Game.maskBuraco)) {
			
			Game.life--;
			Game.crabs.remove(this);
			return;
			
		}
		verificarColisao();
		
		if(Game.life <= 0 ) {
			
			Game.life=3;
			UI.frames=0;
			UI.seconds=0;
			UI.minutes=0;
			Game.points=0;
			speed=0;
			
		}
		
	}
	
	public void verificarColisao() {
		
			Game.isPressed = false;
			if(Game.mx >= x && Game.mx <= x+40) {
				
				if(Game.my >= y && Game.my <= y+40) {
					
					Game.points++;
					Game.crabs.remove(this);
					Game.smoke.add(new Smoke((int)x,(int)y));
					
					
					if(Game.points % 10 == 0) {
						
						speed ++;
						System.out.println(speed);
					}
					return;
				}
				
			}
			
	}
	
	public void render(Graphics g) {
		

			frames++;
			
			if (frames == maxframes) {

				frames = 0;
				index++;

				if (index > maxindex) {

					index = 0;
				}

			}
			g.drawImage(Crab.crabSprite[index], (int)x,(int) y, 40,40, null);
	}
	
}
