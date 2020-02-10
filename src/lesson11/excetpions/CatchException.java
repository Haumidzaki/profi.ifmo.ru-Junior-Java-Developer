package lesson11.excetpions;

import java.util.Arrays;

public class CatchException {
    public static void main(String[] args) {
        // целочисленное деление на ноль
        int a = 9;
        int b = 0;
//        System.out.println(a/b); // ArithmeticException

        // попытка получить 10й элемент
        // массива из массива размером - 5 элементов
        int[] arr = new int[5];
//        arr[10] = 12;
//        System.out.println(Arrays.toString(arr)); // ArrayIndexOutOfBoundsException

        String str = null;
//        str.equals("string"); // NullPointerException

//        Integer.parseInt("asd"); // NumberFormatException

        // обработка исключений осуществляется при помощи try catch

        Object data = "42";
//        Integer intData = (Integer) data; // ClassCastException

        try {
            Integer intData = (Integer) data; // ClassCastException
            System.out.println("после Exception внутри try");
        } catch (ClassCastException e){
            System.out.println("catch ClassCastException " + e.getMessage());
        }

        System.out.println("Код после try catch");

        try {
            if (System.currentTimeMillis() % 2 == 0){
                Integer intData = (Integer) data; // ClassCastException
            } else {
                arr[23] = 12; // ArrayIndexOutOfBoundsException
            }
        }
        // 1 вариант
        catch (ClassCastException e) {
            System.out.println("ClassCastException");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        // 2 вариант
       /* catch (ClassCastException | ArrayIndexOutOfBoundsException e){
            System.out.println("ClassCastException " +
                    "or ArrayIndexOutOfBoundsException" + e.getMessage());
        }*/
        // 3 вариант
        // RuntimeException (общий родитель)
       /* catch (RuntimeException e){
            System.out.println("RuntimeException " + e.getMessage());
            e.printStackTrace();
        } */
        finally {
            System.out.println("блок finally");
            // высвобождения ресурсов, открытых в блоке try
        }

        try {
            voidWithException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            voidWithCheckException(6);
        } catch (CheckedException e) {
            System.out.println("CheckedException " + e.getMessage());
            try {
                throw new UncheckedException("UncheckedException", e);

            } catch (UncheckedException e1){
                System.out.println("e1" + e1.getCause());
            }
        }

    }

    public static void voidWithException() throws Exception {
        // обрабатываемые исключения (checked exception)
//        try {
//            throw new Exception("Some Exception");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        int a = 3;
        int b = 0;
        if (b == 0) {
//            System.out.println("Что-то не так");
            throw new Exception("Some Exception");
        }
    }

    public static void voidWithCheckException(int i) throws CheckedException {
        if (i < 10){
            throw new CheckedException("Bad int data");
        }
    }

}
