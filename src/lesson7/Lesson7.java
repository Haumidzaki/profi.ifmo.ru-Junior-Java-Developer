package lesson7;

public class Lesson7 {

    public static void main(String[] args) {
        int a = 5;
        Integer intVar = 5;
        Byte byteVar;
        Float floatVar;
        Double doubleVar;
        Character character;
        Short shortVar;
        Boolean bool;

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);

        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);

        // методы, преобразующие строку в число
        System.out.println(Byte.parseByte("2")); // byte
        System.out.println(Byte.valueOf("2")); // Byte

        System.out.println(Integer.parseInt("23")); // int
        System.out.println(Integer.valueOf("23")); // Integer

        // -127 до 128
        Integer int1 = 2;
        Integer int2 = 2;
        if (int1 == int2){
            System.out.println("int1 == int2");
        }
        Integer int3 = 300;
        Integer int4 = 300;
        if (int3 == int4){
            System.out.println("int3 == int4");
        } else {
            System.out.println("int3 != int4");
        }

        Integer res = int1 + int2;

        Integer.compare(int1, int2);
        Integer.max(int1, int2);
        Integer.min(int1, int2);

        Integer.hashCode(45);
        Integer.sum(34, 6);

        System.out.println(Integer.parseInt("45aqw")); // NumberFormatException
        int1.longValue(); // вернет примитив
        int1.doubleValue(); // вернет примитив

    }
}
