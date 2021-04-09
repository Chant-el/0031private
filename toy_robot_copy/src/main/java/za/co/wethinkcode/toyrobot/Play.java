package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {
    static Scanner scanner;
    static List<String> history = new ArrayList<String>();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Robot robot;

        String name = getInput("What do you want to name your robot?");
        robot = new Robot(name);
        System.out.println("Hello Kiddo!");

        System.out.println(robot.toString());

        Command command;
        boolean shouldContinue = true;
        do {
            String instruction = getInput(robot.getName() + "> What must I do next?").strip().toLowerCase();

            try {
                command = Command.create(instruction);

                if (command.getName().equals("replay")) {
                    command.execute(robot);
                    continue;
                }
                
                addCommand(command.getName(), command.getArgument());
                shouldContinue = robot.handleCommand(command);
            } catch (IllegalArgumentException e) {
                robot.setStatus("Sorry, I did not understand '" + instruction + "'.");
            }
            System.out.println(robot);
        } while (shouldContinue);
        robot.reset();

    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();

        while (input.isBlank()) {
            System.out.println(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    public static void addCommand(String commandName, String commandArgument) {
        if (!commandName.equals("off") && !commandName.equals("help") && !commandName.equals("replay")){
            history.add(commandName + " " + commandArgument);
        }
    }
}
