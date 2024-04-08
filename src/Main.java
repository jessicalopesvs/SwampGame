import game.Player;
import game.WorldMap;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the map: ");
        int size = scanner.nextInt();
        WorldMap map = new WorldMap(size);
        Player player = new Player(map.getStartX(), map.getStartY(), map);

        while (true) {
            System.out.println("Current Map:");
            map.display(player);

            System.out.print("Enter direction (north, south, west, east): ");
            String direction = scanner.next();
            player.move(direction);

            if (player.x == map.getFinishX() && player.y == map.getFinishY()) {
                System.out.println("Congratulations! You reached the finish.");
                break;
            }
        }
    }
}

