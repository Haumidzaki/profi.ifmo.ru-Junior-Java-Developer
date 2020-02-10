package lesson5.animals;

public interface Run {
    // начиная с java 8 для интерфейсов доступно создание методов с реализацией
    default void stop() {
        System.out.println("Stop");
    }
    public void run();
}
