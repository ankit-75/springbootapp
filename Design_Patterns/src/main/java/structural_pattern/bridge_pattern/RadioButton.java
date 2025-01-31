package structural_pattern.bridge_pattern;

public class RadioButton extends Button {
    ButtonSize buttonSize;

    public RadioButton(ButtonSize buttonSize) {
        this.buttonSize = buttonSize;
    }

    @Override
    void draw() {
        buttonSize.getSize();
        System.out.println("Drawing a radio button");
    }
}
