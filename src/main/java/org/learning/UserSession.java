package org.learning;

public class UserSession {
    private static final UserSession instance = new UserSession();

    private UserSession() {
    }

    public static UserSession getInstance() {
        return instance;
    }

    public User getLoggedInUser() {
        throw new CollaboratorException("User session getLoggedUser shoudl not be called in a unit test");
    }
}
