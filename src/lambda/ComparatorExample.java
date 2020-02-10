package lambda;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        Manager alex = new Manager("Alex", 34, "AGTH");
        Manager peter = new Manager("Peter", 23, "QFKI");
        Manager tom = new Manager("Tom", 46, "RJLY");
        Manager mike = new Manager("Mike", 28, "BTKI");

        ArrayList<Manager> managers = new ArrayList<>();
        managers.add(peter);
        managers.add(tom);
        managers.add(alex);
        managers.add(mike);

//        Comparator<Manager> byName =
//                (manager1, manager2) -> manager1.getName().compareTo(manager2.getName());
        Comparator<Manager> byName = Comparator.comparing(Manager::getName);
        managers.sort(byName);
        System.out.println(managers);

        Comparator<Manager> byAge = Comparator.comparing(Manager::getAge);
        managers.sort(byAge);
        System.out.println(managers);

        Comparator<Manager> byCompany = Comparator.comparing(Manager::getCompany);
        managers.sort(byCompany);
        System.out.println(managers);
    }
}

class Manager {
    private String name;
    private int age;
    private String company;

    public Manager(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }
}
