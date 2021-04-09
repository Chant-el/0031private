package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;

public class SquareObstacle implements Obstacle {
    private static int x;
    private static int y;
    private static int obstacleSize = 5;
    
    public SquareObstacle(int i, int j) {
     this.x = i;
     this.y = j;
    }

    @Override
    public int getBottomLeftX() {
        return this.x;
    }

    @Override
    public int getBottomLeftY() {
        return this.y;
    }

    @Override
    public int getSize() {
        return this.obstacleSize;
    }

    @Override
    public boolean blocksPosition(Position position) {
        return false;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        return false;
    }
}