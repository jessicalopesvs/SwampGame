
package game;

import java.util.Random;

public class Player {
    public int x;   
    public int y;
    WorldMap map;

    public Player(int x, int y, WorldMap map) {
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public void move(String direction) {
        int newX = x, newY = y;
        switch (direction) {
            case "north":
                newX--;
                break;
            case "south":
                newX++;
                break;
            case "west":
                newY--;
                break;
            case "east":
                newY++;
                break;
            default:
                System.out.println("Invalid direction!");
                return;
        }

        int maxX = map.grid.length - 1;
        int maxY = map.grid[0].length - 1;

        if (newX < 0)
            newX = maxX; // Wrap around to the last row if going above the grid
        else if (newX > maxX)
            newX = 0; // Wrap around to the first row if going below the grid

        if (newY < 0)
            newY = maxY; // Wrap around to the last column if going left beyond the grid
        else if (newY > maxY)
            newY = 0; // Wrap around to the first column if going right beyond the grid

        x = newX;
        y = newY;

        map.display(this);
    }
}
