package game;

import javax.swing.text.html.parser.Entity;
import java.util.Random;

public class WorldMap {
    public int[][] grid;

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getFinishX() {
        return finishX;
    }

    public int getFinishY() {
        return finishY;
    }

    private int startX, startY, finishX, finishY;

    public WorldMap(int size) {
        grid = new int[size][size];
        Random random = new Random();
        startX = random.nextInt(size);
        startY = random.nextInt(size);
        do {
            finishX = random.nextInt(size);
            finishY = random.nextInt(size);
        } while (finishX == startX && finishY == startY);
    }

    public void display(Player player) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == player.x && j == player.y) {
                    System.out.print("P ");
                } else if (i == startX && j == startY) {
                    System.out.print("S ");
                } else if (i == finishX && j == finishY) {
                    System.out.print("F ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}