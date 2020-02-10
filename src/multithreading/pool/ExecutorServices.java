package multithreading.pool;

import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] args) {
        // создание фиксированного количества потоков
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.shutdown();

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.shutdown();
//        singleThread.execute(new RunnableTask("singleThread"));

        ExecutorService cachedThread = Executors.newCachedThreadPool();
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        Future future = cachedThread.submit(new RunnableTask("cachedThread"));
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //отложенное выполнение
        ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();
        Future future1 = scheduledService
                .schedule(new CallableTask("scheduledService"), 5, TimeUnit.SECONDS);
        try {
            System.out.println(future1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        scheduledService.shutdown();

        // выполнение каждые 5 секунд
        ScheduledExecutorService runEveryFiveSecond = Executors.newSingleThreadScheduledExecutor();
        runEveryFiveSecond
                .scheduleAtFixedRate(new RunnableTask("runEveryFiveSecond"), 0, 5, TimeUnit.SECONDS);

        runEveryFiveSecond.shutdown();

        ScheduledExecutorService everySecond = Executors.newSingleThreadScheduledExecutor();
        everySecond
                .scheduleWithFixedDelay(new RunnableTask("everySecond"), 0, 1, TimeUnit.SECONDS);







    }
}


class CallableTask implements Callable<Integer> {

    String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Поток: " + name + " = " + (2 + 3));
        return 2 + 3;
    }
}

class RunnableTask implements Runnable {
    String name;

    public RunnableTask(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Поток: " + Thread.currentThread().getName() + " из пула " + name);
    }
}

