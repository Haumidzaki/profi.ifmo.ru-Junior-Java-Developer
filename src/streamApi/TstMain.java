package streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class TstMain {
    public static void main(String[] args) {
        Author mike = new Author("Mike", 34);
        Author peter = new Author("Peter", 12);
        Author alice = new Author("Alice", 67);
        Author tom = new Author("Tom", 33);
        Author jane = new Author("Jane", 17);

        Article article1 = new Article("Java 12", tom, Article.Category.JAVA);
        Article article2 = new Article("From java 8 to java 9", peter, Article.Category.JAVA);
        Article article3 = new Article("Парсинг в Python", alice, Article.Category.PYTHON);
        Article article4 = new Article("Фреймворки", tom, Article.Category.PHP);
        Article article5 = new Article("Работа с БД", alice, Article.Category.PHP);
        Article article6 = new Article("Локальные переменные", jane, Article.Category.JAVA);
        Article article7 = new Article("Flask, Pony", mike, Article.Category.PYTHON);
        Article article8 = new Article("Лямбда", peter, Article.Category.JAVA);
        Article article9 = new Article("new GC", tom, Article.Category.JAVA);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
        articles.add(article7);
        articles.add(article8);
        articles.add(article9);

        // сгруппировать статьи по автору
        articles.stream()
                .collect(Collectors.groupingBy(a->a.getAuthor().getName()))
                .entrySet()
                .forEach(System.out::println);

        // вывести имена авторов по алфавиту
        articles.stream()
                .map(a->a.getAuthor().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // количество статей по каждому автору
        articles.stream()
                .collect(Collectors.groupingBy(a->a.getAuthor().getName(), Collectors.counting()))
                .forEach((a, count)-> System.out.println(a + " : " + count));


        Map<Article.Category, Map<String, List<Article>>> map = articles.stream()
                .sorted(Comparator.comparing(Article::getCategory, Comparator.comparing(Enum::name))
                                    .thenComparing(a->a.getAuthor().getName()))
                .collect(Collectors.groupingBy(Article::getCategory,
                        LinkedHashMap::new, Collectors.groupingBy(a->a.getAuthor().getName())));

        System.out.println(map);


        ArrayList<Author> authors = new ArrayList<>();
        authors.add(mike);
        authors.add(tom);
        authors.add(alice);
        authors.add(peter);
        authors.add(jane);

        IntSummaryStatistics statistics = authors.stream()
                .collect(Collectors.summarizingInt(Author::getAge));
        System.out.println(statistics);
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());

        //
        ArrayList<Developer> developers = new ArrayList<>();

        // группировка по должности - pos
        Map<String, List<Developer>> posMapList = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos));
        Map<String, ArrayList<Developer>> posMap = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos, Collectors.toCollection(ArrayList::new)));

        // количество по должности
        Map<String, Long> posCount = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos, Collectors.counting()));

        // группировка имен по должности
        Map<String, Set<String>> posName = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,
                        Collectors.mapping(Developer::getName, Collectors.toSet())));

        // средняя зп по должности
        Map<String, Double> posAverageSalary = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,
                        Collectors.averagingDouble(Developer::getSalary)));

        //
        Map<String, Map<Integer, List<Developer>>> posAndAge = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,
                        Collectors.groupingBy(Developer::getAge)));
    }
}

class Author {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return name != null ? name.equals(author.name) : author.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Article {
    enum Category {
        JAVA, PHP, PYTHON
    }
    private String title;
    private Author author;
    private Category category;

    public Article(String title, Author author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (author != null ? !author.equals(article.author) : article.author != null) return false;
        return category == article.category;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", category=" + category +
                '}';
    }
}

class Developer {
    private String name;
    private int age;
    private int salary;
    private String pos;

    public Developer(String name, int age, int salary, String pos) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (age != developer.age) return false;
        if (salary != developer.salary) return false;
        if (name != null ? !name.equals(developer.name) : developer.name != null) return false;
        return pos != null ? pos.equals(developer.pos) : developer.pos == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + salary;
        result = 31 * result + (pos != null ? pos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", pos='" + pos + '\'' +
                '}';
    }
}