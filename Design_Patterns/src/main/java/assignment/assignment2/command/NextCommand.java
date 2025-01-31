package assignment.assignment2.command;

public class NextCommand implements Command {
    private Actions actions;

    public NextCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.next();
    }
}
