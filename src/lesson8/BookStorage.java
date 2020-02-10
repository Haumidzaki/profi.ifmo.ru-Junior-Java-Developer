package lesson8;

interface SomeInterface<T> {
    public T getData();
}

public class BookStorage<T extends Book> implements SomeInterface<T>{
    private T book;

    public String getBookTitle() {
        return book.getTitle();
    }

    @Override
    public T getData() {
        return null;
    }
}
