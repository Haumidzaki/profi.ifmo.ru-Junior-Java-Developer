package lesson12.messageApp;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class MessageClient {
    private String server;
    private int port;
    private Connection connection;
    private Scanner scanner;

    public MessageClient(String server, int port) {
        this.server = server;
        this.port = port;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Введите имя");

        String name = scanner.nextLine();
        String messageText;
        while (true){
            System.out.println("Введите сообщение");
            messageText = scanner.nextLine();
            try {
                buildAndSend(name, messageText);
                printMessage();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildAndSend(String name, String messageText) throws IOException {
        connection = new Connection(new Socket(server, port));
        Message message = new Message(name, messageText);
        connection.sendMessage(message);
//        Socket socket = null;
//        try {
////            socket = new Socket();
////            socket.connect(address);
//
//            try (OutputStream out = socket.getOutputStream();
//                 ObjectOutputStream objOut = new ObjectOutputStream(out);
//            ){
//                objOut.writeObject(message);
//                objOut.flush();
//            }
//        }
//        finally {
//            socket.close();
//        }
    }

    private void printMessage() throws IOException, ClassNotFoundException {
        Message message = connection.readMessage();
        System.out.println("ответ от сервера: " + message.getMessageText());
    }

    public static void main(String[] args) {
        try (InputStream inputStream =
                     MessageClient.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")){

            Properties properties = new Properties();
            properties.load(inputStream);

            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port")); //8090;
            MessageClient messageClient =
                    new MessageClient(server, port);
            messageClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}


