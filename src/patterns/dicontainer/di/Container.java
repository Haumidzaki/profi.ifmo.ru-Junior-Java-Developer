package patterns.dicontainer.di;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class Container {
    private ArrayList<Class> classes;

    public Container(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public void start() throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        for (Class cls: classes) {
            if (cls.isAnnotationPresent(Component.class)) {
                Object o = cls.getDeclaredConstructor().newInstance();
                Field[] fields = cls.getDeclaredFields();

                for (Field field: fields) {
                    if (field.isAnnotationPresent(AutoField.class)){
                        field.setAccessible(true);
                        Object o1 = field.getType().getDeclaredConstructor().newInstance();
                        field.set(o, o1);
                        if (o1.getClass().isAnnotationPresent(Config.class)){
                            Field[] fields1 = o1.getClass().getDeclaredFields();
                            try (InputStream stream =
                                    Container.class.getClassLoader().getResourceAsStream("config.properties")
                                    )
                            {
                                Properties properties = new Properties();
                                properties.load(stream);

                                for (Field field1: fields1) {
                                    field1.setAccessible(true);
                                    field1.set(o1, properties.getProperty(field1.getName()));
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }


                Method[] methods = cls.getDeclaredMethods();
                for (Method method: methods) {
                    if (method.isAnnotationPresent(AutoRun.class)){
                        method.setAccessible(true);
                        method.invoke(o);
                    }
                }

            }
        }
    }
}
