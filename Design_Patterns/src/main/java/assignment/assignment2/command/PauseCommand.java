package assignment.assignment2.command;

public class PauseCommand implements Command {
    private Actions actions;

    public PauseCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.pause();
    }
}
