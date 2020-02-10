package patterns.comand;

public class ProcessCommand extends Command {

    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        // добавление пакета данных
        System.out.println("execute ProcessCommand");
        return true;
    }
}
