package behaviour_pattern.interpreter_pattern;

public class Main {
    public static void main(String[] args) {
        String context = "_Int";
        FirstLetterNotUnderscore firstLetterNotUnderscore = new FirstLetterNotUnderscore();
        context = firstLetterNotUnderscore.interpret(context);
        System.out.println(context);
    }
}
