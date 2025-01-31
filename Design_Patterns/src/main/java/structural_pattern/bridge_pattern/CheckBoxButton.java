package structural_pattern.bridge_pattern;

public class CheckBoxButton extends Button {
    ButtonSize buttonSize;

    public CheckBoxButton(ButtonSize buttonSize) {
        this.buttonSize = buttonSize;
    }

    @Override
    void draw() {
        buttonSize.getSize();
        System.out.println("Drawing a checkbox button");
    }
}
