package behaviour_pattern.memento_pattern;

public class DocumentViewer {
    public static TextDocument textDocument = new TextDocument();

    public static void main(String[] args) {
        textDocument.write("Hello");
        textDocument.save();
        textDocument.print();
        textDocument.write(" World");
        textDocument.print();
        textDocument.undo();
        textDocument.print();
    }
}
