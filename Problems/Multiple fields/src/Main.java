import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Utils {

    public static void sortUsers(List<User> users) {
        // your code here
        Comparator<User> userComparator = (u1, u2) -> Objects.equals(u1.getName(), u2.getName())
                ? Integer.compare(u2.getAge(), u1.getAge())  // better swap arguments than reverse a comparator
                : u1.getName().compareTo(u2.getName());

        users.sort(userComparator);
    }


}