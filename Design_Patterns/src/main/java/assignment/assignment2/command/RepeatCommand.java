package assignment.assignment2.command;

public class RepeatCommand implements Command {
    private Actions actions;

    public RepeatCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.repeat();
    }
}
