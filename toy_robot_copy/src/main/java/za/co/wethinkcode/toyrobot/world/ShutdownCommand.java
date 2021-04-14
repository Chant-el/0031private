//THIS IS SERVER SIDE SHUTDOWN COMMAND. IN MY UNDERSTANDIING IT
//EXECUTES ACTION USING SPECIFIC TARGET ROBOT
//MAY BE INCORRECT

package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Robot;

public class ShutdownCommand extends Command {
    public ShutdownCommand(String instruction) {
        super("off");
    }

    public ShutdownCommand() {
        super("off");
    }

    public String resultOfCommand() {
        return "Shutting down...";
    }

    @Override
    public boolean execute(Robot target) {
        //receives request from client(reception may have to be in a different class)
        //if possible to execute the action: send response first(before shutdown)
        System.out.println(getJSONResponse(target, getName()));
        //then execute action
        target.setStatus("Shutting down...");
        target.reset();
        return false;
    }

    // @Override
    // public boolean execute(Robot target) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }
}
