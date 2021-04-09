package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;

public class EmptyMaze implements Maze {

    List<Obstacle> obstacles;

    @Override
    public List<Obstacle> getObstacles() {

        List<Obstacle> obstacles = new ArrayList<Obstacle>();
        return obstacles;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {

        return false;
    }

}