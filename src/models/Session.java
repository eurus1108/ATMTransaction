package models;

public class Session {
    private static Customer user;

    public static Customer getUser() {
        return user;
    }

    public static void setUser(Customer user) {
        Session.user = user;
    }
}
