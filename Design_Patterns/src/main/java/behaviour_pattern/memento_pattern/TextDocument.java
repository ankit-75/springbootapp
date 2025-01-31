package behaviour_pattern.memento_pattern;

public class TextDocument {
    String text = "";
    Memento memento = new Memento(text);

    public void write(String text){
        this.text += text;
    }

    public void print(){
        System.out.println(text);
    }

    public void save(){
        memento.setState(text);
    }

    public void undo(){
        text  = memento.getState();
    }
}

