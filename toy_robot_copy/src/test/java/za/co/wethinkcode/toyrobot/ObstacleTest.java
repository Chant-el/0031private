package za.co.wethinkcode.toyrobot;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import za.co.wethinkcode.toyrobot.world.SquareObstacle;


public class ObstacleTest {
   @Test
   void squareObstacleTestX () {
    SquareObstacle obstacle = new SquareObstacle(1,1);   
    assertEquals(1, obstacle.getBottomLeftX());
   } 

   @Test
   void squareObstacleTestY () {
    SquareObstacle obstacle = new SquareObstacle(1,1);   
    assertEquals(1, obstacle.getBottomLeftY());
   } 

   @Test
   void blocksPosition() {
    SquareObstacle obstacle = new SquareObstacle(1,1);
    Position position = new Position(10,10);   
    assertFalse(obstacle.blocksPosition(position));
   } 

   @Test
   void blocksPath() {
    SquareObstacle obstacle = new SquareObstacle(1,1);
    Position position = new Position(10,10);
    Position newPosition = new Position(20,10);   
    assertFalse(obstacle.blocksPath(position, newPosition));
   } 
}
