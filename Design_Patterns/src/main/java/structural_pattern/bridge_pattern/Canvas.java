package structural_pattern.bridge_pattern;

import java.util.ArrayList;
import java.util.Arrays;

public  class Canvas {
    public static void main(String[] args) {


        Button button1 = new CheckBoxButton(new SmallButtonSize());
        button1.draw();

        Button button2 = new RadioButton(new MediumButtonSize());
        button2.draw();

        Button button3 = new DropDownButton(new LargeButtonSize());
        button3.draw();
    }
}

