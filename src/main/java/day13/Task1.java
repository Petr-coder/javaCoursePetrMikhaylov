package day13;

public class Task1 {
    public static void main(String[] args) {
        User a = new User("a");
        User b = new User("b");
        a.subscribe(b);
        System.out.println(a.getUsername());
        System.out.println(a.isSubscribed(b));

        System.out.println(a.isFriend(b));
    }
}
