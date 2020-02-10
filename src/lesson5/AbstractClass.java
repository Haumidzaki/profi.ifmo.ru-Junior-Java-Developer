package lesson5;


interface SomeInterface {
    public void iVoid();
}

public abstract class AbstractClass implements SomeInterface{
    // в абстрактном классе можно не реализовывать методы интерфейса

    public abstract void abstractVoid();

    public void someVoid(){
        System.out.println("someVoid AbstractClass");
    }
}

class SomeClass extends AbstractClass {

    // класс, наследуемый от абстрактного должен реализовать все его абстрактные методы или стать абстрактным
    @Override
    public void abstractVoid() {
        System.out.println("реализация метода abstractVoid");
    }

    @Override
    public void iVoid() {
        System.out.println("someVoid iVoid");
    }
}
