package multithreading.messageApp;

import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.ClosedByInterruptException;
import java.util.Scanner;

public class MessageClient {
    private Scanner in = new Scanner(System.in);
    private Connection connection;

    public MessageClient(Connection connection) {
        this.connection = connection;
    }

    public void start() throws IOException {
        System.out.println("Введите имя");
        String name = in.nextLine();

        Thread reader = new Thread(new Reader(connection));
        reader.start();

        System.out.println("Введите сообщение");

        while (true) {
            String mess = in.nextLine();

            if(mess != null) {
                Message message = new Message(mess, name);
                connection.sendMessage(message);
            }
        }
    }

    public static void main(String[] args) {
        try {
            MessageClient client =
                    new MessageClient(new Connection(new Socket("127.0.0.1", 8090)));
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class Reader implements Runnable {
        private Connection connection;

        public Reader(Connection connection){
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()){
                    Message message = connection.readMessage();
                    System.out.println(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


}
