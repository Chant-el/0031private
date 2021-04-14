package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.world.IWorld;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.EmptyMaze;

public class TextWorld implements IWorld {

    private final Position TOP_LEFT = new Position(-100,200);
    private final Position TOP_RIGHT = new Position(100,200);
    private final Position BOTTOM_LEFT = new Position(-200,-100);
    private final Position BOTTOM_RIGHT = new Position(200,-100);

    private Position position = IWorld.CENTRE;
    private Direction currentDirection = Direction.UP;

    private String centre;

    public TextWorld(EmptyMaze maze) {

    }

    @Override
    public UpdateResponse updatePosition(int nrSteps) {

        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.UP.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }
        else if (Direction.DOWN.equals(this.currentDirection)){
            newY = newY - nrSteps;
        }
        else if (Direction.LEFT.equals(this.currentDirection)){
            newX = newX - nrSteps;
        }
        else {
            newX = newX + nrSteps;
        }


        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return UpdateResponse.SUCCESS;
        }
        return UpdateResponse.FAILED_OUTSIDE_WORLD;    
    }

    @Override
    public void updateDirection(boolean turnRight) {
        
        if (turnRight) {
            this.currentDirection = IWorld.Direction.RIGHT;
        } else {
            this.currentDirection = IWorld.Direction.LEFT;
        }
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    @Override
    public boolean isNewPositionAllowed(Position position) {
       
        if (position.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = position;
            return true;
        }
        return false;
    }

    @Override
    public boolean isAtEdge() {
        
        if (position.getX() == -100 || position.getX() == 100 || position.getY() == -200 || position.getY() == 200) {
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        
        this.position = IWorld.CENTRE;
        this.currentDirection = Direction.UP;
    }

    @Override
    public List<Obstacle> getObstacles() {

        List<Obstacle> obstacles = new ArrayList<Obstacle>();
        return obstacles;
    }

    @Override
    public void showObstacles() {
        
    }

}