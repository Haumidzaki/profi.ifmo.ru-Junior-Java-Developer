package lesson2;

import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите код. Трехзначное число");
        int code = in.nextInt(); // 123

        if (code == 123){
            System.out.println("Вы вошли как администратор");
        } else if (code == 345) { // дополнительный else if
            System.out.println("Вы вошли как участник");
        } else { // необязательный блок else
            System.out.println("Вы не вошли");
        }


        int a = 5;
        int b = 7;
        if (a == 5) {
            System.out.println("Совпадение найдено: а");
            if (b == 7){
                System.out.println("Совпадение найдено: b" +
                        "- вложеный if");
            }
        } else if (b == 7){
            System.out.println("Совпадение найдено: b");
        } else {
            System.out.println("Совпадений нет");
        }

        // ------------- switch (оператор выбора)


        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите шестизначный номер бтлета.");
        int userTicketNum = in2.nextInt();
        String prize;
        switch (userTicketNum) {
            case 333333:
                prize = "Большой приз";
                break;
            case 333334:
            case 333335:
                prize = "Средний приз";
                break;
            case  333344:
            case  333355:
            case  333366:
                prize = "Малый приз";
                break;
            default:
                prize = "Приза нет";
        }
        System.out.println("Результат " + prize);

        // ---------------
        // while
        int messageCount = 5;


        while (messageCount > 0){
            // вывод собщения
            System.out.println("Сообщение № " + messageCount);
            messageCount--;
        }



//      цикл с постусловием do while
        do {
            System.out.println("Первая итерация");
        } while (false);

        // цикл for
//        for (инициализация; проверка условия; шаг) {тело цикла}

        for (int i = 1; i < 11; i++){
            if (i % 2 == 0) {
                System.out.println("i = " + i);
            }
        }

        for (int i = 1; i < 11; i++){
            if (i % 2 == 0) continue;
            System.out.println("i = " + i);
        }

        for (int i = 0; i < 3; i++){
            System.out.println("внешний цикл. i = " + i);
            for (int j = 0; j < 15; j++){
                System.out.println("j = " + j);
                if (j == 5) break;
            }
        }

        outer: for (int i = 0; i < 3; i++){
                System.out.println("внешний цикл. i = " + i);
                for (int j = 0; j < 15; j++){
                    System.out.println("j = " + j);
                    if (j == 5) break outer;
                }
            }
    }
}
