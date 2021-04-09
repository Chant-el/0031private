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
        System.out.println(getJSONMsg(target, getName()));
        // target.setStatus("Shutting down...");
        // target.reset();
        return false;
    }
}
