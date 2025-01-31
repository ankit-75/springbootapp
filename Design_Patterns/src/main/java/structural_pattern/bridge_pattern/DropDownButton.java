package structural_pattern.bridge_pattern;

public class DropDownButton extends Button {
    ButtonSize buttonSize;

    public DropDownButton(ButtonSize buttonSize) {
        this.buttonSize = buttonSize;
    }

    @Override
    void draw() {
        buttonSize.getSize();
        System.out.println("Drawing a dropdown button");
    }
}
