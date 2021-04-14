package za.co.wethinkcode.toyrobot.world;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.WorldConfiguration;
import za.co.wethinkcode.toyrobot.Robot;

public class AbstractWorld implements IWorld {

    WorldConfiguration worldconfig = new WorldConfiguration();

    private final Position CENTRE = worldconfig.getCentre();
    private final Position TOP_LEFT = worldconfig.getTopLeft();
    private final Position TOP_RIGHT = new Position(200,100);
    private final Position BOTTOM_LEFT = new Position(-100,-200);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    private Position position;
    private Direction currentDirection = Direction.UP;


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

        if (position == TOP_LEFT || position == BOTTOM_RIGHT || position == TOP_RIGHT || position == BOTTOM_LEFT) {
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        
        //not sure how to work around this
        this.position = CENTRE;
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
