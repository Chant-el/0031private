package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplayCommand extends Command {

    private String[] commandArgs;

    static List<String> replayList;
    List<String> history = Play.history;

    int n;
    int m = 0;

    public ReplayCommand(String argument) {
        super("replay", argument);
    }

    @Override
    public boolean execute(Robot target) {
        Command command;
        setCommandArgs();
        replayList = ReplayArgs(history);

        for (String i : replayList) {

            command = Command.create(i);
            target.handleCommand(command);
            System.out.println(target);
            
        }
        target.setStatus("replayed " + replayList.size() + " commands.");
        System.out.println(target);
        return true;
    }

    //I am trying to return the "argument" in the above constructor
    //because it contains the details of how the replay should be executed. 
    public void setCommandArgs() {
        String args = getArgument();
        this.commandArgs = args.split(" ");      
    }

    /** 
     * gets the n vale of the replay range
     * and returns it as an int.
     * @param range
     * @return n of 'replay n-m'*/
    public int getReplayRangeN(String range) {
        String[] rangeIndex = range.split("-");
        return history.size() - Integer.parseInt(rangeIndex[0]);
    }

    /** 
     * gets the m vale of the replay range
     * and returns it as an int.
     * @param range
     * @return m of 'replay n-m'*/
    public int getReplayRangeM(String range) {
        String[] rangeIndex = range.split("-");
        return history.size() - Integer.parseInt(rangeIndex[1]);
    }
    
    /** 
     * processes the user's replay command and 
     * reduces the history list to return the ordered list of replay;
     *@param history
     *@return list of commands to replay in replay order
     */
    public List<String> ReplayArgs(List<String> historyList){
        
        if (commandArgs.length == 3 && commandArgs[2].contains("-") && commandArgs[1].contains("reversed")) {
            n = getReplayRangeN(commandArgs[2]);
            m = getReplayRangeM(commandArgs[2]);
            return reverseHistory(replayList(n, m, historyList));
        } else if (commandArgs.length == 2 && commandArgs[1].contains("-")){
            n = getReplayRangeN(commandArgs[1]);
            m = getReplayRangeM(commandArgs[1]);
            return replayList(n, m, historyList);
        } else if (commandArgs.length == 2 && commandArgs[1].contains("reversed")) {
            return reverseHistory(historyList);
        } else if (commandArgs.length == 1) {
            return historyList;
        } else if (commandArgs.length == 3 && commandArgs[1].contains("reversed")){ 
            n = getReplayRangeN(commandArgs[2]);
            m = history.size();
            return reverseHistory(replayList(n,m, historyList));
        } else {
            n = getReplayRangeN(commandArgs[1]);
            m = history.size();
            return replayList(n,m, historyList);
        }
    }

    /**
     * reduces the history list to the commands that
     * need to be replayed.
     * @param n
     * @param m
     * @param historyList
     * @return all the commands to be returned
     */
    public List<String> replayList(int n, int m, List<String> historyList) {
        List<String> commandsToReplay = new ArrayList<String>();
        for (int i = n ; i < m; i++) {
            commandsToReplay.add(historyList.get(i));
        }
        return commandsToReplay;
    }

    /**
     * reverses the list of commands that need to be replayed
     * in reverse.
     * @param historyList
     * @return commands to be replayed in the reverse order
     */
    public List<String> reverseHistory(List<String> historyList) {
        List<String> commandsToReplay = new ArrayList<String>();
        for (int i = historyList.size() -1; i >= 0; i-- ) {
            commandsToReplay.add(historyList.get(i));
        }
        return commandsToReplay;
    }

}
