//THIS IS COMMAND ON SERVER SIDE

package za.co.wethinkcode.toyrobot.world;

import java.util.List;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

import za.co.wethinkcode.toyrobot.Robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public abstract class Command {
    private final String name;
    private String argument;

    JSONObject obj = new JSONObject();
    JSONObject data = new JSONObject();
    JSONObject state = new JSONObject();

    public List<String> history;

    public abstract boolean execute(Robot target);

    public JSONObject getJSONResponse(Robot target, String instruction) {

        List<String> argument = new ArrayList<String>();
        String[] arguments = instruction.toLowerCase().trim().split(" ");
        state.put("position", target.getPosition());
        state.put("direction", target.getCurrentDirection());
        state.put("shields", target.getShields());
        state.put("shots", target.getShots());
        state.put("status", target.getStatus());

        data.put("key1", "value1");
        data.put("key2", "value2");
        
        obj.put("result", "Shutting down...");
        obj.put("data", data);
        obj.put("state", state);


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

