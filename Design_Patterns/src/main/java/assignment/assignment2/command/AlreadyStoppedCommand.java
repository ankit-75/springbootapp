package assignment.assignment2.command;

public class AlreadyStoppedCommand implements Command {
    private Actions actions;

    public AlreadyStoppedCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.alreadyStopped();
    }
}
