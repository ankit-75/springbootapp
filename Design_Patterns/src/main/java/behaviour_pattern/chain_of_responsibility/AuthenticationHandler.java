package behaviour_pattern.chain_of_responsibility;

public abstract class AuthenticationHandler {
    private AuthenticationHandler next;

    public  AuthenticationHandler(AuthenticationHandler next) {
        this.next = next;
    }

    public void handleRequest(String reqeustType){
        if(next != null){
            next.handleRequest(reqeustType);
        }
    }
}
