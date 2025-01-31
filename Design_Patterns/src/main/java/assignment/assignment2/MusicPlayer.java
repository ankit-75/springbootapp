package assignment.assignment2;

import assignment.assignment2.command.*;

import java.util.List;

public class MusicPlayer implements Player {
    private Actions actions;
    private boolean playOrPauseToggle;
    private boolean stopToggle;

    public MusicPlayer(List<String> list) {
        actions = new Actions(list);
        playOrPauseToggle = true;
        stopToggle = false;
    }

    @Override
    public void playOrPause() {
        if(playOrPauseToggle){
            executeCommand(new PlayCommand(actions));

        }else{
            executeCommand(new PauseCommand(actions));
        }
        playOrPauseToggle = !playOrPauseToggle;
        stopToggle = true;

    }

    @Override
    public void stop() {
        if(stopToggle){
            executeCommand(new StopCommand(actions));
            stopToggle = false;
        }else{
            executeCommand(new AlreadyStoppedCommand(actions));
        }

    }

    @Override
    public void next() {
        executeCommand(new NextCommand(actions));
    }

    @Override
    public void previous() {
        executeCommand(new PreviousCommand(actions));
    }

    @Override
    public void repeatOnOrOff() {
        executeCommand(new RepeatCommand(actions));

    }

    public void executeCommand(Command command){
        command.execute();
    }
}
