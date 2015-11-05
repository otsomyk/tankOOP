package tanksOOP;

public class Tank {
	private int direction;

	private int tankX = 128;
	private int tankY = 512;
	private ActionField af;
	private BattleField bf;

	private int speed = 10;

	public int getYPos(int tankX, int tankY) {
		String newPosition = getQuadrant(tankX, tankY);
		int YPos = Integer.valueOf(newPosition.substring(0,
				newPosition.indexOf("_")));
		return YPos;
	}

	public int getXPos(int tankX, int tankY) {
		String newPosition = getQuadrant(tankX, tankY);
		int XPos = Integer.valueOf(newPosition.substring(
				newPosition.indexOf("_") + 1, newPosition.length()));
		return XPos;
	}
	
	public String getQuadrant (int x, int y){
		return "";
	}

	public boolean checkLimits(int direction) {
		if ((direction == 1 && tankY == 0) || (direction == 2 && tankY == 512)
				|| (direction == 3 && tankX == 0)
				|| (direction == 4 && tankX == 512)) {
			System.out.println("[illegal move] direction: " + direction
					+ " tankX: " + tankX + ", tankY: " + tankY);
			return true;
		} else {
			return false;
		}
	}

	public void move(long direction) throws Exception {
		int step = 4;
		int covered = 0;
		if (checkLimits((int) direction) == true) {
			return;
		}
		turn(direction);
		while (covered < 64) {
			if (direction == 1) {
				tankY -= step;
			} else if (direction == 2) {
				tankY += step;
			} else if (direction == 3) {
				tankX -= step;
			} else {
				tankX += step;
			}
			covered += step;

		}
	}

	public void turn(long direction) {
		if (direction != direction) {
			direction = (int) direction;
		}
	}

	long random() {
		long time = System.currentTimeMillis() / 100;
		return time % 5;
	}

	public void moveRandom() throws Exception {
		long direction = random();
		turn(direction);
		move(direction);
	}

	public String getQuadrantXY(int v, int h) {
		return "";
	}
	
	public void moveAndFire(int direction){
		
	}

	public void moveToQuadrant(int v, int h) throws Exception {
		int x = Integer.valueOf(getQuadrantXY(v, h).substring(0,
				getQuadrantXY(v, h).indexOf("_")));
		int y = Integer.valueOf(getQuadrantXY(v, h).substring(
				getQuadrantXY(v, h).indexOf("_") + 1,
				getQuadrantXY(v, h).length()));
		int i = 0;
		int tankX0 = tankX;
		int tankY0 = tankY;

		if (tankY0 < y) {
			while (i < (y - tankY0) / 64) {
				moveAndFire(2);
			}
		} else if (tankY0 > y) {
			while (i < (tankY0 - y) / 64) {
				moveAndFire(1);
			}
		}

		if (tankX0 < x) {
			while (i < (x - tankX0) / 64) {
				moveAndFire(4);
			}
		} else if (tankX0 > x) {
			while (i < (tankX0 - x) / 64) {
				moveAndFire(3);
			}
		}

	}

}