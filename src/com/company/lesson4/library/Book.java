package com.company.lesson4.library;

public class Book {
//    свойства (атрибуты, поля)
    private int pageCount;
    private String title;
    private Author author;

    // конструктор
    public Book() {}

    public Book(int pageCount){
        this.pageCount = pageCount;
    }

    public Book (Author author){
        this.author = author;
    }

    public Book(int pageCount, String title){
        this.pageCount = pageCount;
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setPageCount(int pageCount) {
        // проверка входящих данных
        if (pageCount < 1) {
            System.out.println("Ошибка в количестве страниц");
            return; // выполнение метода прекращается
        }
        this.pageCount = pageCount;
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

    @Override
    public String toString() {
        return "Book{" +
                "pageCount=" + pageCount +
                ", title='" + title + '\'' +
                '}';
    }

}
