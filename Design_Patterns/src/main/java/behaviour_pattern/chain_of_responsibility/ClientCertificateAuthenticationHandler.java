package behaviour_pattern.chain_of_responsibility;

public class ClientCertificateAuthenticationHandler extends AuthenticationHandler{
    public ClientCertificateAuthenticationHandler(AuthenticationHandler authenticationHandler){
        super(authenticationHandler);
    }

    @Override
    public void handleRequest(String reqeustType) {
        if(reqeustType.equals("ClientCertificate")){
            System.out.println("Handled in ClientCertificateAuthenticationHandler");
        }
        super.handleRequest(reqeustType);
    }
}
