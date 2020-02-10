package lesson6.nested;

public interface Logger {
    public void log();
}

class SomeClass{

    public void someVoid(){
        // анонимные классы
        Logger logger = new Logger() {

            @Override
            public void log() {
                System.out.println("log smth");
            }

        };

        logger.log();

        Logger logger1 = new Logger() {
            @Override
            public void log() {
                System.out.println("log smth 2");
            }
        };

    }
}

