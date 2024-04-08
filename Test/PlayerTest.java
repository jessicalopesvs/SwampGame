import game.Player;
import game.WorldMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class PlayerTest {

    WorldMap map;
    Player player;
    int sumPos;

        @BeforeEach
        void setUp() {
            map = new WorldMap(5);
            player = new Player(2, 2, map);
        }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testInvalidMove() {
        player.move("invalid");
        assertEquals(2, player.x); // Should not move
    }

    @Test
    void moveNorth() {
        map.display(player);
        player.move("north");
        System.out.println();
        map.display(player);
        sumPos = player.x + player.y;
        assertEquals(3, sumPos);
    }

    @Test
    void moveSouth() {
        player.move("south");
        sumPos = player.x + player.y;
        assertEquals(5, sumPos);
    }

    @Test
    public void testMoveWest() {
        player.move("west");
        sumPos = player.x + player.y;
        assertEquals(3, sumPos);
    }

    @Test
    public void testMoveEast() {

        player.move("east");
        sumPos = player.x + player.y;
        if (player.x == 2 && player.y == 3) {
            assertEquals(5, sumPos);
        } else fail("Test failed");
    }

    @Test
    public void testWrapAroundNorth() {
        player.x = 0;
        player.move("north");
        assertEquals(4, player.x); // Wrap around to the last row
    }

    @Test
    public void testWrapAroundSouth() {
        player.x = 4;
        player.move("south");
        assertEquals(0, player.x); // Wrap around to the first row
    }

    @Test
    public void testWrapAroundWest() {
        player.y = 0;
        player.move("west");
        assertEquals(4, player.y);
    }

    @Test
    public void testWrapAroundEast() {
        player.y = 4;
        player.move("east");
        assertEquals(0, player.y);
    }


}