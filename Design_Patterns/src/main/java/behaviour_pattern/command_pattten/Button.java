package behaviour_pattern.command_pattten;

public class Button {
    private String text;
    public Button(String text){
        this.text = text;

    }

    public void click(Command command){
        command.execute();
    }
}
