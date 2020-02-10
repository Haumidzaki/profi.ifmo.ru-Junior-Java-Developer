package lesson13;


import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionExample {
    // Рефлексия в java

    public static void main(String[] args) throws
            NoSuchFieldException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        System.out.println(String.class);
        System.out.println(int.class);

        SomeClass someClass = new SomeClass();
        System.out.println(someClass.getClass());

        Class cls = someClass.getClass();
        System.out.println(cls.getName());

        cls = cls.getSuperclass();
        System.out.println(cls.getName());

        // доступ к компонентам класса
        Class<SomeClass> someCls = SomeClass.class;

        // доступ к полям класса
        Field[] fields = someCls.getFields();
        System.out.println(Arrays.toString(fields));

        Field[] declaredField = someCls.getDeclaredFields();
        System.out.println(Arrays.toString(declaredField));

        // доступ к методам
        Method[] methods = someCls.getMethods();
        System.out.println(Arrays.toString(methods));

        Method[] declaredMethods = someCls.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к конструкторам
        Constructor<?>[] declaredConstructors = someCls.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));


        someClass = new SomeClass();

        // доступ к конкретному полю, методу, конструктору
        Field field = someCls.getDeclaredField("version");
        System.out.println(field.getType());
        field.setAccessible(true);
        System.out.println(field.get(someClass));
        field.set(someClass, 1); // задает значение поля
        System.out.println(someClass);

        // доступ к приватному методу
        Method method = someCls.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        String data = (String) method.invoke(someClass);
        System.out.println("data: " + data);

        // конструктор
        Constructor<SomeClass> someClassConstructor =
                someCls.getDeclaredConstructor(String.class, int.class);
        SomeClass someClass1 =
                someClassConstructor.newInstance("SomeClass", 3);
        System.out.println(someClass1);

        //
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());
        boolean isFinal = Modifier.isFinal(field.getModifiers());



        // написать статический toString(obj),
        // который возвращает информацию о переданном объекте
    }
//    public static void toString(SomeClass someClass){
//
//    }
}



class ParentClass {
    public String parentField;
    public void parentVoid(){
        System.out.println("parent void");
    }
}

class SomeClass extends ParentClass {

    private String name;
    private int version;

    public SomeClass(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public SomeClass() {
    }

    public SomeClass(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private String getInfo(){
        return "private Void";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

   /* public void setVersion(int version) {
        this.version = version;
    }*/

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}