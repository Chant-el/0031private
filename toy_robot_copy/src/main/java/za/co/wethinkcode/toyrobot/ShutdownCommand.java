package za.co.wethinkcode.toyrobot;

public class ShutdownCommand extends Command {
    public ShutdownCommand(String instruction) {
        super("off");
    }

    public ShutdownCommand() {
        super("off");
    }

    @Override
    public boolean execute(Robot target) {
        //first sends the message to server
        System.out.println(getJSONMsg(target, getName()));
        //after receiving response from server 
        //executes the action:
        target.setStatus("Shutting down...");
        target.reset();
        return false;
    }
}
