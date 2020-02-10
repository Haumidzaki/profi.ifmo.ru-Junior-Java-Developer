package lesson8;

public class Main {

    public static void main(String[] args) {
        Book tails = new Book("tails", 34);

        Book flowers = new Book("flowers", 56);

        Car car = new Car("red");


//        LinkedList bookStorage = new LinkedList();
//        bookStorage.add(tails);
//        bookStorage.add(flowers);
//
//        bookStorage.add(car);

//        Object bookFromStorage1 = bookStorage.get(0);
//        System.out.println(bookFromStorage1.getTitle());
//        Book bookFromStorage1 = (Book) bookStorage.get(0);
//        System.out.println(bookFromStorage1.getTitle());
//
//        Book bookFromStorage2 = (Book) bookStorage.get(2); // ClassCastException
//        System.out.println(bookFromStorage2.getTitle());

        LinkedList<Book> bookStorage = new LinkedList<>();
        bookStorage.add(tails);
        bookStorage.add(flowers);

//        bookStorage.add(car);

        LinkedList<Car> carStorage = new LinkedList<>();
        carStorage.add(car);
//        carStorage.add(flowers);

        Book bookFromStorage3 = bookStorage.get(0);
        System.out.println(bookFromStorage3.getTitle());

        Car carFromStorage = carStorage.get(0);
        System.out.println(carFromStorage.color);

        LinkedList<ChildBook> childBookStorage = new LinkedList<>();
        ChildBook coloring = new ChildBook("coloring", 23);
        childBookStorage.add(coloring);

        Book book = getFirsBook(childBookStorage);

    }

    // со всеми потомками
    public static OtherBook getFirsBook(LinkedList<? extends Book> storage){

//        OtherBook book = new OtherBook("book", 12);
//        storage.add(book);
        return (OtherBook) storage.get(0);
    }

    // класс Book и все предки
    public void addToStorage(LinkedList<? super Book> storage){
        Book book = new Book("book", 234);
        storage.add(book);

//        Book book1 = storage.get(0);
        Object o = storage.get(0);
        System.out.println(o);
    }

    // перегружать методы generic нельзя
//    public void someVoid(LinkedList storage){}
//    public void someVoid(LinkedList storage){}

//    public static T staticVoid(){}

    public static void storage(LinkedList<?> storage) {
//        Object book = new Book("book", 123);
//        Object object = new Object();
//        storage.add(object);
//        storage.add(book);
        storage.add(null);

//        Book book1 = storage.get(0);
//        Object o = storage.get(0);
    }


}
