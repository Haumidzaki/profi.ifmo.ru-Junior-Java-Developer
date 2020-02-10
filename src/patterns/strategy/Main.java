package patterns.strategy;

public class Main {
    public static void main(String[] args) {
        LoggerContext context = new LoggerContext();
        context.setLogger(new ConsoleLogger());
        context.write("Console info");

        context.setLogger(new FileLogger());
        context.write("File info");
    }
}
