package behaviour_pattern.interpreter_pattern;

public class FIrstLetterIsLowerCase implements Expression {
    private NameNotPremitiveType nameNotPremitiveType = new NameNotPremitiveType();

    @Override
    public String interpret(String context) {
        context = context.substring(0,1).toLowerCase() + context.substring(1);
        return  nameNotPremitiveType.interpret(context);
    }
}
