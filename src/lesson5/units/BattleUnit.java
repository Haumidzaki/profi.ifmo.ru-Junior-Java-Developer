package lesson5.units;

// класс BattleUnit наследуется от класса Unit (множественное наследование классов запрещено)
public class BattleUnit extends Unit {
    protected int attackScore;

    public BattleUnit(int health, int attackScore) {
        // вызов конструктора родителя
        super(health);
        this.attackScore = attackScore;
    }

    public void attack(BattleUnit enemy) {
        if (!isAlive()) { // isAlive() - метод родителя, доступный дочернему классу
            System.out.println("Персонаж мертв");
            return;
        }

        enemy.health -= this.attackScore; // attackScore - свойство родителя, доступное дочернему классу
    }
}
