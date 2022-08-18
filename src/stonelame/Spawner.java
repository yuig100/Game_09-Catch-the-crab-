package stonelame;

import java.util.Random;

public class Spawner {
	
	public int curTime=0,TargetTime=60 * 2;
	public Random random;
	public Spawner() {
		
		random = new Random();
		
	}
	public void update() {
		
		curTime++;
		if(curTime == TargetTime) {
			
			curTime = 0;
			
			if(random.nextInt(100) < 50) {
				
				Game.crabs.add(new Crab(random.nextInt(Game.WIDTH - 40),-40));
				
			} else {
				
				Game.crabs.add(new Crab(-40,random.nextInt(Game.HEIGHT- 40)));
				
			}
			
		}
		
	}
	
}
