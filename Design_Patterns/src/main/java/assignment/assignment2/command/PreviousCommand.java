package assignment.assignment2.command;

public class PreviousCommand implements Command {
    private Actions actions;

    public PreviousCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.previous();
    }
}
