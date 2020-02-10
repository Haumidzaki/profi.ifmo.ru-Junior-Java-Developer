package multithreading.pool;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) {
        Callable<UserInfo> callable1 = new CreateUserTask(2000);
        Callable<UserInfo> callable2 = new CreateUserTask(3000);

        FutureTask<UserInfo> futureTask = new FutureTask<>(callable1);
        FutureTask<UserInfo> futureTask2 = new FutureTask<>(callable2);

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(futureTask);
        service.execute(futureTask2);

        while (true){
            if (futureTask.isDone() && futureTask2.isDone()){
                System.out.println("Задачи выполнены");
                service.shutdown();
                return;
            }

            if (futureTask.isDone()){
                try {
                    System.out.println("futureTask result: " + futureTask.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ожидание завершения futureTask2...");

            try {
                UserInfo userInfo = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if (userInfo != null) {
                    System.out.println("futureTask2 result: " + futureTask2.get());
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}

class UserInfo {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}

class CreateUserTask implements Callable<UserInfo> {

    long sleepTime;

    public CreateUserTask(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public UserInfo call() throws Exception {
        Thread.sleep(sleepTime);
        UserInfo userInfo = new UserInfo();
        userInfo.setName(Thread.currentThread().getName());
        return userInfo;
    }
}

