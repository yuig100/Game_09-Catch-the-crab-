package stonelame;

import java.awt.Graphics;

public class Smoke {
	
	public int x,y;
	private int frames = 0, maxframes = 5, index = 4, maxindex = 7;
	
	public Smoke(int x,int y){
		
		this.x=x;
		this.y = y;
		
	}
	
	public void update() {
		
		frames++;
		
		if (frames == maxframes) {

			frames = 0;
			index++;

			if (index > maxindex) {
				Game.smoke.remove(this);
				index = 4;
			}

		}
		
	}
	
	public void render(Graphics g) {
		
		
		g.drawImage(Crab.crabSprite[index], (int)x,(int) y, 40,40, null);
	}
	
}
