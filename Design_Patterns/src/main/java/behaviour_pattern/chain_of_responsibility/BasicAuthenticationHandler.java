package behaviour_pattern.chain_of_responsibility;

public class BasicAuthenticationHandler extends AuthenticationHandler{
    public BasicAuthenticationHandler(AuthenticationHandler authenticationHandler){
        super(authenticationHandler);
    }

    public void handleRequest(String reqeustType){
        if(reqeustType.equals("Basic")){
            System.out.println("Handled in BasicAuthenticationHandler");
        }else{
            super.handleRequest(reqeustType);
        }
    }
}
