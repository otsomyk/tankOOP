package tanksOOP;

import java.util.Random;

public class BattleField {
	public final int BF_WIDTH = 576;
	public final int BF_HEIGHT = 576;

	String[][] battleField = new String[9][9];

	public void createRandomBattlefield() {
		Random rand = new Random();
		for (int i = 0; i <= 9; i++) {
			for (int k = 0; k <= 9; k++) {
				if (rand.nextInt(3) == 1) {
					battleField[i][k] = "B";
				} else {
					battleField[i][k] = " ";
				}
			}
		}
	}
	
	public String getQuadrant(int x, int y) {
		return y / 64 + "_" + x / 64;
	}
	
	public String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}
}