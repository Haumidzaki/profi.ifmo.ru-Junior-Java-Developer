package multithreading.synchronize;

public class Robot {

    volatile boolean current = true;

    class Leg implements Runnable {
        String name;
        boolean leg;

        public Leg(String name, boolean leg) {
            this.name = name;
            this.leg = leg;
        }

        @Override
        public void run() {
            while (true) {
                if (leg == current) {
                    step();
                    current = !leg;
                    Thread.yield();
                }
            }
        }

        void step() {
            System.out.println(name);
        }
    }

    Leg left = new Leg("left", false);
    Leg right = new Leg("right", true);

    void start() {
        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main(String[] args) {
        new Robot().start();
    }
}
