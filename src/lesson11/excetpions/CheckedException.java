package lesson11.excetpions;

// обрабатываемые исключения (checked exception)
public class CheckedException extends Exception{
    public CheckedException() {
    }

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}

