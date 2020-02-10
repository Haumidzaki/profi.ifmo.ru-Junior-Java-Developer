package multithreading;

public class MultiThreadingExample {

    // start() - запуск потока

    // Thread.currentThread() - получение текущего потока
    // setName(name) задать имя потоку
    // getName() - получить имя потока
    // getState() - возвращает текущее состояние потока
//    isAlive() - возвращает true, если поток выполняется,
//    в противном случае возвращает false

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();


        Thread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread1 = new Thread(new OtherThread("Один"));
        System.out.println("thread1: " + thread1.getState());
        Thread thread2 = new Thread(new OtherThread("Два"));
        Thread thread3 = new Thread(new OtherThread("Три"));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            System.out.println("Ожидание завершения потоков");
            thread1.join();
//            thread2.join();
//            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread1: " + thread1.getState());


        // инициализация анонимным классом
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running: " + Thread.currentThread().isAlive());
                System.out.println("Running: " + Thread.currentThread().getState());
            }
        });

        thread4.start();
//        thread4.setDaemon(true);

        /*Thread whileThread = new WhileThread();
        whileThread.setDaemon(true);
        whileThread.start();*/

        // Прерывание потока
//        Поток останавливается в следующих случаях:
//        1. Если поток выполнил все инструкции и вышел из метода run()
//        2. Если в потоке было выброшено необрабатываемое исключение
//        3. Остановилась JVM
//        4. Если это Daemon поток и основной поток завершил свою работу

        // у каждого потока существует флаг,
        // который можно проверить методом isInterrupted();

        // interrupt()

        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("thread5");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        });

        thread5.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread5.interrupt();


        System.out.println("Завершение основного потока");
    }
}




class WhileThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("WhileThread");
        }
    }
}


// создание класса потока,
//наследование от класса Thread
class MyThread extends Thread {

    @Override
    public void run() {
        Thread.currentThread().setName("MyThread");
        System.out.println(Thread.currentThread().getName());
    }
}

class OtherThread implements Runnable {

    String name;

    public OtherThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 0; i < 3; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}