package lesson8;

public class Book {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }
}

class ChildBook extends Book{

    public ChildBook(String title, int pageCount) {
        super(title, pageCount);
    }
}

class OtherBook extends Book {

    public OtherBook(String title, int pageCount) {
        super(title, pageCount);
    }
}
