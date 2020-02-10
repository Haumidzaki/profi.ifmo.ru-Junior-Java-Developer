package lesson9.collect;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) throws IOException {
        // порядок элементов сохранен
//        ArrayList<Book> bookArrayList = new ArrayList<>(30);
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Cars"));
        bookArrayList.add(2, new Book("Alfabet")); // IndexOutOfBoundsException
        System.out.println(bookArrayList.size());
        for (Book book: bookArrayList){
            System.out.println(book.getTitle());
        }

//        LinkedHashSet
    // порядок элементов может быть не сохранен
        Set<Book> bookSet = new HashSet<>(bookArrayList);
        System.out.println("bookSet");
        for (Book book: bookSet){
            System.out.println(book.getTitle());
        }

        System.out.println("--bookLinkedList--");
        LinkedList<Book> bookLinkedList = new LinkedList<>();
        bookLinkedList.add(new Book("Book 1"));
        bookLinkedList.add(new Book("Book 2"));
        bookLinkedList.add(new Book("Book 3"));
        bookLinkedList.add(1, new Book("Book 3"));

        for (Book book: bookLinkedList){
            System.out.println(book.getTitle());
        }
        System.out.println("--TreeSet--");
        TreeSet<String> strings = new TreeSet<>();
        strings.add("Hello");
        strings.add("Hi");
        strings.add("Asd");

        for (String str: strings){
            System.out.println(str);
        }

        TreeSet<Book> bookTreeSet = new TreeSet<>();
        bookTreeSet.add(new Book("Book 1"));
        bookTreeSet.add(new Book("Book 2"));
        System.out.println(bookTreeSet);

        User user1 = new User("qwe", 23);
        User user2 = new User("asd", 23);
        TreeSet<User> users = new TreeSet<>(new UserComparator());
        users.add(user1);
        users.add(user2);
        for (User user: users){
            System.out.println(user.getName());
        }

        Comparator<User> userComparator = new UserNameComparator()
                .thenComparing(new UserAgeComparator());

        TreeSet<User> userTreeSet = new TreeSet<>(userComparator);
        userTreeSet.add(new User("Qwe", 34));
        userTreeSet.add(new User("Qwe", 12));
        userTreeSet.add(new User("Tom", 34));
        userTreeSet.add(new User("Alex", 56));

        for (User user: userTreeSet){
            System.out.println(user.getName() + " - " + user.getAge());
        }

        ClassLoader loader = CollectionExample.class.getClassLoader();
        File file = new File(loader.getResource("file.txt").getFile());

        // Читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line: lines){
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                                        .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                                        .trim() // убираем пробелы
                                        .split("\\s");
            for (String s: wordSplit){
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }
        for (String word: words) {
            System.out.println(word);
        }
    }
}


// для хранения объектов в TreeSet
// класс должен расширять интерфейс Comparable
class Book implements Comparable<Book>{
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }

    // 0 - объекты равны
    // отрицательное значение - объект будет стоять до Object o
    // положительное значение - объект будет стоять после Object o
    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.getTitle());
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class UserNameComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class UserAgeComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

