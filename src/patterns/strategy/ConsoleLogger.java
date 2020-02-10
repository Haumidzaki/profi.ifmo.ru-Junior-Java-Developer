package patterns.strategy;

public class ConsoleLogger implements ILogger{

    @Override
    public void write(String info) {
        System.out.println("Log Info: " + info);
    }
}
