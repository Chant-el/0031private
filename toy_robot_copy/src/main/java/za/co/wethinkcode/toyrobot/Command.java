package za.co.wethinkcode.toyrobot;

import java.util.List;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Command {
    private final String name;
    private String argument;

    JSONObject obj = new JSONObject();

    public List<String> history;

    public abstract boolean execute(Robot target);

    public JSONObject getJSONMsg(Robot target, String instruction) {
        List<String> argument = new ArrayList<String>();
        String[] arguments = instruction.toLowerCase().trim().split(" ");
        obj.put("robot", target.getName());
        obj.put("command", arguments[0]);

        argument = Arrays.asList(arguments);

        // System.out.println(instruction);

        if (arguments.length > 1){ 
            obj.put("arguments", argument. subList(1, arguments.length));
        } else {
            obj.put("arguments", "[]");
        }

        return obj;
    }

    public Command(String name){
        this.name = name.trim().toLowerCase();
        this.argument = "";
    }

    public Command(String name, String argument) {
        this(name);
        this.argument = argument.trim();
    }

    public Command(String name, String argument, List<String> history) {
        this(name);
        this.argument = argument.trim();
        this.history = history;
    }

    public String getName() {                                                                           //<2>
        return name;
    }

    public String getArgument() {
        return this.argument;
    }

    public List<String> getHistory() {
        return this.history;
    }

    public static Command create(String instruction) {
        String[] args = instruction.toLowerCase().trim().split(" ");
        System.out.println(instruction);
        switch (args[0]){
            case "shutdown":
            case "off":
                return new ShutdownCommand(instruction);
            case "help":
                return new HelpCommand(instruction);
            case "forward":
                return new ForwardCommand(instruction);
            case "back":
                return new BackCommand(instruction);
            case "left":
                return new LeftCommand("left");
            case "right":
                return new RightCommand("right");
            case "replay":
                return new ReplayCommand(instruction);
            case "sprint":
                return new SprintCommand(instruction);
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }
}

