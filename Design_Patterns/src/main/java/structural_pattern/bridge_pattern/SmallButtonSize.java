package structural_pattern.bridge_pattern;

public class SmallButtonSize implements ButtonSize {
    @Override
    public void getSize() {
        System.out.println("Setting size to small");
    }
}
