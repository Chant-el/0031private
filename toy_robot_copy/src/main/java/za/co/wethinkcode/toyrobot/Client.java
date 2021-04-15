package za.co.wethinkcode.toyrobot;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        try (
            Socket socket = new Socket("localhost", 5000);
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(
                      socket.getInputStream()));
            )
        {   while(true){
            System.out.println("Input message to the serveer ");
            out.println(scanner.nextLine());
            out.flush();
            String messageFromServer = in.readLine();
            System.out.println("Response: "+messageFromServer);

        }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}