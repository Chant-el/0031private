package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Robot;

public class SprintCommand extends Command {

    @Override
    public boolean execute(Robot target) {
        System.out.println(getArgument());
        int nrSteps = Integer.parseInt(getArgument());
        
        for (int i = nrSteps; i > 0; i--) {

            if (i == 1) {
                Command forward = new ForwardCommand("1");
                return forward.execute(target);
            } else {
                Command forwardcomm = new ForwardCommand(Integer.toString(i));
                forwardcomm.execute(target);
                System.out.println(target);
            }
        }
        return false;
    }
    
    public SprintCommand (String argument) {
        super("sprint", argument);
    }

    @Override
    public boolean execute(Robot target) {
        // TODO Auto-generated method stub
        return false;
    }
}
