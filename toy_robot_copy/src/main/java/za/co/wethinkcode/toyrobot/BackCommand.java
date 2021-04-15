package za.co.wethinkcode.toyrobot;

import org.json.JSONObject;
import com.google.gson.Gson;

public class BackCommand extends Command {

    //Our execute should probably execute sending the message via server
    @Override
    public boolean execute(Robot target) {

        int nrSteps = Integer.parseInt(getArgument());
        if (target.updatePosition(-nrSteps)){
            target.setStatus("Moved back by " + nrSteps + " steps.");
        } else {
            target.setStatus("Sorry, I cannot go outside my safe zone.");
        }
        return true;
    }

    public BackCommand(String argument) {
        super("back", argument);
    }

    public Object[] getArguments() {
        
        Object[] arguments = getArgument().split(" ");
        return arguments;
    }

    public JSONObject JSONRequestMsg(Robot target) {
        
        JSONObject requestMsg = new JSONObject();

        requestMsg.put("robot", target.getName());
        requestMsg.put("command", getName());
        requestMsg.put("arguments", getArguments());

        return requestMsg;
    }

    public String JSONRequestString(JSONObject message) {
        
        String jsonString = message.toString();

        return jsonString;

    }
}