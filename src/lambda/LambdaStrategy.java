package lambda;

import java.util.concurrent.ConcurrentSkipListMap;

public class LambdaStrategy {
    public static void main(String[] args) {
        Order order = new Order(700);
        order.payOrder("card");
        order.payOrder("payPal");

    }
}


class StrategyRegister<T> {
    private ConcurrentSkipListMap<String, T> map = new ConcurrentSkipListMap<>();

    public void add(String actionName, T action) {
        map.put(actionName, action);
    }

    public T get(String actionName) {
        return this.map.get(actionName);
    }

    public void remove(String actionName){
        this.map.remove(actionName);
    }
}

class Order {
    private StrategyRegister<Runnable> payActions = new StrategyRegister<>();

    private int sum;

    public Order(int sum) {
        this.sum = sum;
        payActions.add("card", ()-> System.out.println(Thread.currentThread().getName() + " : " + sum));
        payActions.add("payPal", ()-> System.out.println(Thread.currentThread().getName() + " : " + sum));
    }

    public void payOrder(String payName) {
        payActions.get(payName).run();
    }
}


enum PayActions{
    // все стратегии
}