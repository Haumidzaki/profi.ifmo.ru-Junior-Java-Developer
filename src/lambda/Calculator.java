package lambda;

public class Calculator {
    public double calculate(int a, int b, Operation operation){
        return operation.execute(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Operation add = (a, b)-> a + b;
        Operation div = (a, b) -> {
            if (b == 0) {
                throw new IllegalArgumentException("на 0 делить нельзя");
            }
            return a / b;
        };

//        () -> реализация;
//        a -> реализация;
//        (a, b) -> реализация;
//        (a, b) -> {
//            действие;
//            действие;
//            return результат;
//        };

        System.out.println(calculator.calculate(3, 5, add));
        System.out.println(calculator.calculate(3, 5, div));
        System.out.println(calculator.calculate(3, 5, (a, b)->a-b));
    }

}

@FunctionalInterface
interface Operation {
    double execute(double a, double b);
    // функциональный интерфейс содержит только один абстрактный метод,
    // любое количество default и static методов
}