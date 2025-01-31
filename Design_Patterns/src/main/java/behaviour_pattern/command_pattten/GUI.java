package behaviour_pattern.command_pattten;

public class GUI {
    private static Document document = new Document();
    public static void main(String[] args) {
        Button saveButton = new Button("save");
        Button printButton = new Button("print");

        saveButton.click(new SaveCommand(document));
        printButton.click(new PrintCommand(document));
    }
}
