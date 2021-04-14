package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Robot;

public class BackCommand extends Command {

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

    public Object JSONResponseMsg () {
        return null;
    }

    // @Override
    // public boolean execute(za.co.wethinkcode.toyrobot.world.Robot target) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }
}