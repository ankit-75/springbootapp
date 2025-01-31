package structural_pattern.bridge_pattern;

public class MediumButtonSize implements ButtonSize {
    @Override
    public void getSize() {
        System.out.println("Setting size to medium");
    }
}
