package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("qwe", 34, "Russia");
        User user2 = new User("asd", 56, "Canada");
        User user3 = new User("zxc", 78, "German");
        User user4 = new User("rty", 23, "China");
        User user5 = new User("fgh", 40, "Canada");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Listeners listeners = new Listeners(users);
        System.out.println(listeners.getMore45());

        List<User> russianUsers =
                listeners.getFilterUsers(user->"Russia".equals(user.getCountry()));
        System.out.println(russianUsers);

        Predicate<User> russiaFilter = user->"Russia".equals(user.getCountry());
        Predicate<User> ageFilter = user->user.getAge() > 45;
        Predicate<User> canadaFilter = user->"Canada".equals(user.getCountry());

        System.out.println(listeners.getFilterUsers(canadaFilter));
        System.out.println(listeners.getFilterUsers(canadaFilter.and(ageFilter)));
        System.out.println(listeners.getFilterUsers(canadaFilter.or(russiaFilter)));


    }
}

class Listeners {
    private List<User> userList;

    public Listeners(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getRussianUsers(){
        List<User> list = new ArrayList<>();
        for (User user: userList) {
            if ("Russia".equals(user.getCountry())) {
                list.add(user);
            }
        }
        return list;
    }

    public List<User> getMore45(){
        List<User> list = new ArrayList<>();
        for (User user: userList) {
            if (user.getAge() > 45) {
                list.add(user);
            }
        }
        return list;
    }

    public List<User> getFromCanada45() {
        List<User> list = new ArrayList<>();
        for (User user: userList) {
            if ("Canada".equals(user.getCountry()) && user.getAge() > 45) {
                list.add(user);
            }
        }
        return list;
    }

    // с использованием predicate
    public List<User> getFilterUsers(Predicate<User> filter){
        List<User> list = new ArrayList<>();
        for (User user: userList) {
            if (filter.test(user)){
                list.add(user);
            }
        }
        return list;
    }
}


class User {
    private String login;
    private int age;
    private String country;

    public User(String login, int age, String country) {
        this.login = login;
        this.age = age;
        this.country = country;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return country != null ? country.equals(user.country) : user.country == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}