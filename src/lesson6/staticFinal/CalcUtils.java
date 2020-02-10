package lesson6.staticFinal;

public final class CalcUtils {
    // статические свойства
    static final double PI;

    // статические блоки
    static {
        PI = 3.14;
    }

    // статичесик метод
    public static double summ(int a, int b) {
        return a + b;
    }

    // final методы нельзя переопределить в дочерних классах
    // final аргументы доступны только для чтения в методе
    public final void someVoid(final int a){}

}

//class Utils extends CalcUtils {
////    @Override
////    public final void someVoid(){}
//}
