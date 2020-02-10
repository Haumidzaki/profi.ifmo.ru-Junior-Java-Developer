package patterns.dicontainer;

import patterns.dicontainer.di.AutoField;
import patterns.dicontainer.di.AutoRun;
import patterns.dicontainer.di.Component;

@Component
public class Human {
    @AutoField
    Cat cat;
    Dog dog;

    public Human() {
        System.out.println("human init");
    }

    @AutoRun
    public void walkWithCat(){
        System.out.println("walk with " + cat.getCatName());
    }

}
