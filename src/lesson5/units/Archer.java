package lesson5.units;

public class Archer extends BattleUnit {
    public Archer(int health, int attackScore) {
        super(health, attackScore);
    }

    // переопределение метода родителя
    @Override
    public void attack(BattleUnit enemy) {
        // функционал метода родителя может быть изменен
        enemy.health -= this.health + 3;
    }

    // методе родительского класса переопределять необязательно,
    // можно просто добавлять новые методы, необходимые данному классу
}
