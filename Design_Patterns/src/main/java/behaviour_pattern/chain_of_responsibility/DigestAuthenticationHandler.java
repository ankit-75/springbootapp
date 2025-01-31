package behaviour_pattern.chain_of_responsibility;

public class DigestAuthenticationHandler extends AuthenticationHandler{
    public DigestAuthenticationHandler(AuthenticationHandler authenticationHandler){
        super(authenticationHandler);
    }

    @Override
    public void handleRequest(String reqeustType) {
        if(reqeustType.equals("Digest")){
            System.out.println("Handled in DigestAuthenticationHandler");
        }
        super.handleRequest(reqeustType);
    }
}
