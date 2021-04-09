package za.co.wethinkcode.toyrobot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReplayCommandTest {

    @Test
    void replayRangeReversed() {
        ReplayCommand replay = new ReplayCommand("Replay reversed 4-2");
        List<String> history = new ArrayList<String>();
        history = Arrays.asList("forward 10", "forward 20", "back 30", "back 20");
        assertEquals(Arrays.asList("forward 20", "forward 10"), replay.reverseHistory(replay.replayList(0, 2, history)));
    }

    @Test
    void replayRange() {
        ReplayCommand replay = new ReplayCommand("Replay 4-2");
        List<String> history = new ArrayList<String>();
        history = Arrays.asList("forward 10", "forward 20", "back 30", "back 20");
        assertEquals(Arrays.asList("forward 10", "forward 20"), replay.replayList(0, 2, history));
    }

    @Test
    void replayReversed() {
        ReplayCommand replay = new ReplayCommand("Replay reversed");
        List<String> history = new ArrayList<String>();
        history = Arrays.asList("forward 10", "forward 20", "back 30", "back 20");
        assertEquals(Arrays.asList("back 20", "back 30", "forward 20", "forward 10"), replay.reverseHistory(history));
    }

    @Test
    void replayNReversed() {
        ReplayCommand replay = new ReplayCommand("Replay reversed 2");
        List<String> history = new ArrayList<String>();
        history = Arrays.asList("forward 10", "forward 20", "back 30", "back 20");
        assertEquals(Arrays.asList("back 20", "back 30"), replay.reverseHistory(replay.replayList(2, history.size(), history)));
    }

    @Test
    void replayNcommands() {
        ReplayCommand replay = new ReplayCommand("Replay 3");
        List<String> history = new ArrayList<String>();
        history = Arrays.asList("forward 10", "forward 20", "back 30", "back 20");
        assertEquals(Arrays.asList("forward 20", "back 30", "back 20"), replay.replayList(1, history.size(), history));
    }

}