package tanksOOP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import tank.BattleField;
import tank.Bullet;
import tank.Tank;

public class ActionField {
	
	private BattleField battleField;
	private Tank tank;
	private Bullet bullet;

	public boolean processInterception() {
		int y = getYPos(bullet.getX(), bullet.getY());
		int x = getXPos(bullet.getX(), bullet.getY());

		if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {

			if (!battleField[y][x].trim().isEmpty()) {
				battleField[y][x] = " ";
				return true;
			}
		}
		return false;
	}
	public void fire(Bullet bullet) throws Exception {
		bullet.getX() = tankX + 25;
		bulletY = tankY + 25;
		while ((bulletX > -14 && bulletX < BF_WIDTH + 14)
				&& (bulletY > -14 && bulletY < BF_HEIGHT + 14)) {
			bulletMove();
			if (processInterception()) {
				bulletX = -100;
				bulletY = -100;
				break;
			}
			repaint();
			Thread.sleep(bullet.getSpeed());
		}
	}
	public void moveAndFire (int tankDirection) throws Exception {
		int i = 0;
		move(tankDirection);
		i++;
		fire();
	}
	

	public void clear() throws Exception {
		for (int i = 1; i <= 9; i++) {
			for (int k = 1; k <= 9; k++) {
				if (!battleField[i - 1][k - 1].equals(" ")) {
					moveToQuadrant(k, i);
				}
			}
		}
}
