package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Robot;

public class RightCommand extends Command {

    Direction currentDirection;

    @Override
    public boolean execute(Robot target) {

        currentDirection = target.getCurrentDirection();
        
        switch (currentDirection) {
            case NORTH:
                target.setDirection(Direction.EAST);
                break;
            case WEST:
                target.setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                target.setDirection(Direction.WEST);
                break;
            case EAST:
                target.setDirection(Direction.NORTH);
                break;
        }
        target.setStatus("Turned right.");
        return true;
    }        

    public RightCommand(String argument) {
        super("right");
    }
}