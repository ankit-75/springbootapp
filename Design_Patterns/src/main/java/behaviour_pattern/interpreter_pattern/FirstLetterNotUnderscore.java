package behaviour_pattern.interpreter_pattern;

public class FirstLetterNotUnderscore implements Expression {
    private FIrstLetterIsLowerCase fIrstLetterIsLowerCase = new FIrstLetterIsLowerCase();
    @Override
    public String interpret(String context) {
        if(context.startsWith("_")){
            context = context.substring(1);
        }
        return fIrstLetterIsLowerCase.interpret(context);
    }
}
