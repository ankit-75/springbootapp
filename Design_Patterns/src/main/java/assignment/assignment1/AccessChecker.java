package assignment.assignment1;

public class AccessChecker {
    private static AccessChecker instance;
    private ServerConfig config = ServerConfig.getInstance();

    public static AccessChecker getInstance() {
        if (instance == null) {
            // create instance
            instance = new AccessChecker();
        }
        return instance;
    }



    private AccessChecker() {
        // initialization..
    }

    public boolean mayAccess(User user, String path) {
        String userLevel = config.getAccessLevel(user);
        // check if level suffices

        return false;

    }


}
