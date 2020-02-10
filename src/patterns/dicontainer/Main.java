package patterns.dicontainer;

import patterns.dicontainer.di.Container;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Human human = new Human();
//        Cat cat = new Cat();
//        human.cat = cat;
//        cat.catName = "Tom";





        ArrayList<Class> classes = new ArrayList<>();
        classes.add(Cat.class);
        classes.add(Dog.class);
        classes.add(Human.class);

        try {
            new Container(classes).start();
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
