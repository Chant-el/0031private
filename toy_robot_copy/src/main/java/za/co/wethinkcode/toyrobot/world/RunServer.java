package za.co.wethinkcode.robotworld;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunServer {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        ServerSocket s = new ServerSocket( ClientThread.PORT);                                                  
        System.out.println("Server running & waiting for client connections.");
        RunServer server = new RunServer();
        server.getObstacles();
        server.showObstacles();
        while(true) {
            try {
                Socket socket = s.accept();                                                                     
                System.out.println("Connection: " + socket);

                Runnable r = new ClientThread(socket);                                                          
                Thread task = new Thread(r);
                task.start();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private static List<Obstacles> obstacles = new ArrayList<>();

    public static List<Obstacles> retObstacles() {
        return obstacles;
    }

    public List<Obstacles> getObstacles() {
        Random random = new Random();
        for(int i = 0; i < random.nextInt(11); i++){
            obstacles.add(new SquareObstacles(random.nextInt(100 +100)-100,random.nextInt(200 +200)-200));
        }
        return obstacles;
    } 

    public void showObstacles() {
        System.out.println("There are some obstacles:");
        for(Obstacles ob: obstacles){
            int x = ob.getBottomLeftX() + 4;
            int y = ob.getBottomLeftY() + 4;
            System.out.println("- At position " + ob.getBottomLeftX()+","+ ob.getBottomLeftY()
            + " (to "+ x +","+ y +")");
        }
    }
}
    

