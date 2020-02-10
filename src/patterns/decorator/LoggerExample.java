package patterns.decorator;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class LoggerExample {
    public static void main(String[] args) {
        ILogger logger = new Logger();
        logger.write("log message");

        ILogger logger1 = new DateLogger(new Logger());
        logger1.write("log message");

        ILogger logger2 = new AuthorLogger(new DateLogger(new Logger()));
        logger2.write("log message");

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        System.out.println(fileName);
    }
}


interface ILogger{
    public void write(String message);
}

class Logger implements ILogger {

    @Override
    public void write(String message) {
        System.out.println("Console: " + message);
    }
}

class LoggerDecorator implements ILogger {

    private ILogger iLogger;

    public LoggerDecorator(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    @Override
    public void write(String message) {
        iLogger.write(message);
    }
}

class DateLogger extends LoggerDecorator {

    public DateLogger(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void write(String message) {
        String newMessage = message + ", date: " + new Date();
        super.write(newMessage);
    }
}

class AuthorLogger extends LoggerDecorator{

    public AuthorLogger(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void write(String message) {
        String newMessage = message + ", author: " + System.getProperty("user.name");
        super.write(newMessage);
    }
}

class MyInputStream extends FilterInputStream {

    public MyInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {

        return super.read(b);
    }
}

class MyOutputStream extends FilterOutputStream {

    public MyOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {

        super.write(b);
    }
}





