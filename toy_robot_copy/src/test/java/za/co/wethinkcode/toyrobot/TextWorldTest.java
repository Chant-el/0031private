package za.co.wethinkcode.toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import za.co.wethinkcode.toyrobot.maze.EmptyMaze;
import za.co.wethinkcode.toyrobot.world.IWorld;
import za.co.wethinkcode.toyrobot.world.TextWorld;

public class TextWorldTest {
    @Test
    void resetPosition() {
        IWorld newworld = new TextWorld(new EmptyMaze());
        newworld.updatePosition(-10);
        newworld.reset();
        assertEquals(IWorld.CENTRE, newworld.getPosition());
    }

    @Test
    void resetDirection() {
        IWorld newworld = new TextWorld(new EmptyMaze());
        newworld.updateDirection(false);
        newworld.reset();
        assertEquals(IWorld.Direction.UP, newworld.getCurrentDirection());
    }

    // @Test
    // void isAtTopRightEdge() {
    //     IWorld world = new TextWorld(new EmptyMaze());
    //     world.updatePosition(100);
    //     Position pos = new Position(IWorld.CENTRE.getX(),IWorld.CENTRE.getY() +100);
    //     System.out.println(world.getPosition() == pos);
    //     world.updateDirection(true);
    //     world.updatePosition(200);
    //     assertTrue(world.isAtEdge());
    // }
}
