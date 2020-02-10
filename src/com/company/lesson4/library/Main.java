package com.company.lesson4.library;

public class Main {
    public static void main(String[] args) {
// тип данных имя_объкта = new создание объекта (вызов конструктора)
        Book book1 = new Book();
        System.out.println(book1);
        // обращение к свойству объекта
//        book1.pageCount = -34;
        book1.setPageCount(34);
//        book1.title = "";
        book1.setTitle("Азбука");

        System.out.println(book1);

        Book book2 = new Book();
//        book2.pageCount = 122;
        book2.setPageCount(122);
//        book2.title = "Сказки";
        book2.setTitle("Сказки");

        System.out.println(book2);

        Book book3 = new Book(89);
        System.out.println(book3);

        Book book4 = new Book(223, "Story");
        System.out.println(book4);

        int book4PageCount = book4.getPageCount();
        System.out.println("book4PageCount = " + book4PageCount);

        Author author = new Author("Иван", "Петров");
        book4.setAuthor(author);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        System.out.println(library);
        System.out.println(library.getBook("Сказки"));


    }
}
