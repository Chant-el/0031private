package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Robot;

public class ForwardCommand extends Command {
    @Override
    public boolean execute(Robot target) {
        getJSONMsg(target, getName());
        // System.out.println(getJSONMsg(target, getName()));
        // int nrSteps = Integer.parseInt(getArgument());
        // if (target.updatePosition(nrSteps)){
        //     target.setStatus("Moved forward by "+nrSteps+" steps.");
        // } else {
        //     target.setStatus("Sorry, I cannot go outside my safe zone.");
        // }
        return true;
    }

    public ForwardCommand(String argument) {
        super("forward", argument);
    }

    @Override
    public boolean execute(Robot target) {
        // TODO Auto-generated method stub
        return false;
    }
}

