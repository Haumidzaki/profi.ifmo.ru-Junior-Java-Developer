package lesson5.animals;

public class Cat extends Animal implements Run, Eat {

    // если у обоих интерфейсов есть метод с реализацией stop нужно указать конкретную реализацию
    @Override
    public void stop() {
        System.out.println("Cat stop");
    }

    @Override
    public void run() {
        System.out.println("Cat run");
    }

    @Override
    public void eat(Animal animal) {
        System.out.println("Cat eat " + animal.color);
    }
}
