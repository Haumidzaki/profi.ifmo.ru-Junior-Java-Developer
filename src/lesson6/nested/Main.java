package lesson6.nested;

public class Main {
    public static void main(String[] args) {
        Food apple = new Food.Builder(4)
                .calories(45)
                .fat(6)
                .build();

        System.out.println(apple);

        LinkedList list = new LinkedList();
        list.add(3);
        list.add(45);
        list.add(6);

        for (Object o: list){
            System.out.println(o);
        }

    }
}
