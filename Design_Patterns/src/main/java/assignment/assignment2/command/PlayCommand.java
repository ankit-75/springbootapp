package assignment.assignment2.command;

public class PlayCommand implements Command {
    private Actions actions;

    public PlayCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.play();
    }
}
