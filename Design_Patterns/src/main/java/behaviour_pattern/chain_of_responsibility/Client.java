package behaviour_pattern.chain_of_responsibility;

public class Client {
    public static void main(String[] args) {
        AuthenticationHandler authenticationHandler = new ClientCertificateAuthenticationHandler(new DigestAuthenticationHandler(new BasicAuthenticationHandler(null)));
        authenticationHandler.handleRequest("Basic");
        authenticationHandler.handleRequest("Digest");
        authenticationHandler.handleRequest("ClientCertificate");
        authenticationHandler.handleRequest("Other");
    }

}
