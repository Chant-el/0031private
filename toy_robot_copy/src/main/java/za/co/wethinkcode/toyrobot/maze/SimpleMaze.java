package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;

public class SimpleMaze implements Maze {

    @Override
    public List<Obstacle> getObstacles() {

        SquareObstacle square = new SquareObstacle(1, 1);
        List<Obstacle> obstacles = new ArrayList<Obstacle>();
        obstacles.add(square);
        return obstacles;
    }
    
    @Override
    public boolean blocksPath(Position a, Position b) {

        return false;
    }
    
}