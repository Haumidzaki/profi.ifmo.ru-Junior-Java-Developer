package patterns.comand;

public class ExitCommand extends Command{

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return null;
    }

    @Override
    boolean execute() {
        // реализация выхода из программы
        System.out.println("execute ExitCommand");
        return true;
    }
}
