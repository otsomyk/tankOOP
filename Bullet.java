package tanksOOP;

public class Bullet {
	public int x;
	public int y;
	private int step = 4;
	private int speed = 5;
	private int direction;

	public void bulletMove() throws Exception {
		if (direction == 1) {
			y -= step;
		} else if (direction == 2) {
			y += step;
		} else if (direction == 3) {
			x -= step;
		} else {
			x += step;
		}
	}
	
	public void destroy (){
		x = -100;
		y = -100;
	}
}