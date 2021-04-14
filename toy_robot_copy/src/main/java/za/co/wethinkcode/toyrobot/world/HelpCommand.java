package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Robot;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    public HelpCommand(String instruction) {
        super("help");
    }

    @Override
    public boolean execute(Robot target) {
        System.out.println(getJSONMsg(target, getName()));
        // target.setStatus("I can understand these commands:\n" +
        //         "OFF  - Shut down robot\n" +
        //         "HELP - provide information about commands\n" +
        //         "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'");
        return true;
    }

    @Override
    public boolean execute(Robot target) {
        // TODO Auto-generated method stub
        return false;
    }
}
