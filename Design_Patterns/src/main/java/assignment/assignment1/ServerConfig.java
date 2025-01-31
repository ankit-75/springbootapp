package assignment.assignment1;

public class ServerConfig {
    private static ServerConfig instance;

    private static String configFilePath = "...";

    public static ServerConfig getInstance() {
        if (instance == null) {
            // create instance
            instance = new ServerConfig();
        }
        return instance;
    }

    private ServerConfig() {
        // load configuration from file
        // validate
    }

    public String getAccessLevel(User u) {
        return null;
    }

}
