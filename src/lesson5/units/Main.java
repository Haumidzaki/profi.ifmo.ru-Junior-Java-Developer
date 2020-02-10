package lesson5.units;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer(12, 23);
        Knight knight = new Knight(34, 17);

        Scanner in = new Scanner(System.in);
        System.out.println("Выбор персонажа");
        String heroType = in.nextLine();

        BattleUnit unit;

        if ("knight".equals(heroType)) {
            unit = new Knight(12, 34);
        } else {
            unit = new Archer(36, 22);
        }
        unit.attack(archer);
    }
}
