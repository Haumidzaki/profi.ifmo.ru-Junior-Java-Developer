package lesson5.animals;

public interface Eat {
    // начиная с java 8 для интерфейсов доступно создание методов с реализацией
    default void stop() {
        System.out.println("Stop eat");
    }

    public void eat(Animal animal);
}
