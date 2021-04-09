package za.co.wethinkcode.toyrobot;

public class LeftCommand extends Command {

    Direction currentDirection;

    @Override
    public boolean execute(Robot target) {

        currentDirection = target.getCurrentDirection();
        
        switch (currentDirection) {
            case NORTH:
                target.setDirection(Direction.WEST);
                break;
            case EAST:
                target.setDirection(Direction.NORTH);
                break;
            case SOUTH:
                target.setDirection(Direction.EAST);
                break;
            case WEST:
                target.setDirection(Direction.SOUTH);
                break;
        }
        target.setStatus("Turned left.");
        return true;
    }        

    public LeftCommand(String argument) {
        super("left");
    }

}