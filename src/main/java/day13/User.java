package day13;

import java.util.ArrayList;
import java.util.List;

import static day13.MessageDatabase.addNewMessage;

public class User {
    private String username;
    private List<User> subscriptions = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    public void subscribe(User user) {
        subscriptions.add(user);
    }

    public boolean isSubscribed(User user) {
        return subscriptions.contains(user);
    }

    public boolean isFriend(User user) {
        return subscriptions.contains(user) && user.subscriptions.contains(this);
    }

    public void sendMessage(User user, String text) {
        addNewMessage(this, user, text);
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
