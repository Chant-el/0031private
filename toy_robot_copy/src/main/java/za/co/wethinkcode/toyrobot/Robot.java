package za.co.wethinkcode.toyrobot;

public class Robot {
    private final Position TOP_LEFT = new Position(-200,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    //set shields and centre from config file
    public static final Position CENTRE = new Position(0,0);
    private static int shields = 10;
    //get shots valueOf
    private static int shots = 100;

    private Position position;
    private Direction currentDirection;
    private String status;
    private String name;


    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = Direction.NORTH;
    }

    public String getStatus() {
        return this.status;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public void setDirection(Direction direction){
        this.currentDirection = direction;
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    public boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.NORTH.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }
        else if (Direction.SOUTH.equals(this.currentDirection)){
            newY = newY - nrSteps;
        }
        else if (Direction.WEST.equals(this.currentDirection)){
            newX = newX - nrSteps;
        }
        else {
            newX = newX + nrSteps;
        }


        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
       return "[" + this.position.getX() + "," + this.position.getY() + "] "
               + this.name + "> " + this.status;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public static void updateShots(int shotsFired) {
        shots += shotsFired;
    }

    public int getShots() {
        return shots;
    }

    public void updateShields(int hit) {
        
        shields += hit;
    }

    public int getShields() {
        return shields;
    }

    public void reset(){
        this.position = new Position(0, 0);
        this.currentDirection = Direction.NORTH;
        Play.history.clear();
    }

}
