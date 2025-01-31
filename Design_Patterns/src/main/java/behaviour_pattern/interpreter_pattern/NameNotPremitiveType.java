package behaviour_pattern.interpreter_pattern;

public class NameNotPremitiveType implements Expression {
    @Override
    public String interpret(String context) {
        if(context.equals("int") || context.equals("double")){
            context = context + "1";
        }
        return context;
    }
}
