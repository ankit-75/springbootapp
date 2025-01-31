package assignment.assignment2.command;

public class StopCommand implements Command {
    private Actions actions;

    public StopCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.stop();
    }
}
