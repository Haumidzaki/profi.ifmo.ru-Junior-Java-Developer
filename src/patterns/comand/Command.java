package patterns.comand;

public abstract class Command {
    abstract String name();
    abstract boolean execute();

    protected TextProcessor processor;
    public Command(TextProcessor processor){
        this.processor = processor;
    }
}
