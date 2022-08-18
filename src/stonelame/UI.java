package stonelame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UI {
	
	public static int seconds = 0;
	public static int minutes = 0;
	public static int frames = 0;
	
	public void tick() {
		frames++;
		if(frames == 60) {
			//Passou 1 segundo.
			frames = 0;
			seconds++;
			if(seconds == 60) {
				seconds = 0;
				minutes++;
				if(UI.minutes % 2 == 0) {
					
				}
			}
		}
				
	}
	
	public void render(Graphics g) {
		
		for(int i=0;i < Game.life;i++) {
			
			g.drawImage(Game.spritesheet.getSprite(144, 0), 370 + (i * 33),-8,55,55,null);

		}
		
		String formatTime = "";
		if(minutes < 10) {
			formatTime+="0"+minutes+":";
		}else {
			formatTime+=minutes+":";
		}
		
		if(seconds < 10) {
			formatTime+="0"+seconds;
		}else {
			formatTime+=seconds;
		}
		

		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,23));
		g.drawString(formatTime,200, 30);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,23));
		g.drawString("" + Game.points, 65, 35);
		g.drawImage(Game.spritesheet.getSprite(0, 0), 10, -5, 45, 45, null);
		
		
	}
}
