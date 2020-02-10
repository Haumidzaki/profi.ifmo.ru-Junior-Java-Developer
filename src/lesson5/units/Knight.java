package lesson5.units;

// класс Knight наследуется от класса BattleUnit (множественное наследование классов запрещено)
public class Knight extends BattleUnit{

    public Knight(int health, int attackScore) {
        // вызов конструктора родителя
        super(health, attackScore);
    }

    // переопределение метода родителя
    @Override
    public void attack(BattleUnit enemy) {
        super.attack(enemy); // вызов метода родитея
        // расширение функционала
        enemy.health -= 1;

    }
}
