package behaviour_pattern.command_pattten.jacket;

public class OrderHandler {

    public void invoke(Command command){
        command.execute();
    }
}
