package lesson13.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationExample {
    String name;

    @Override
    @MethodInfo(date = "12.02.2019", author = "user", version = 2)
    public String toString() {
        return "AnnotationExample{" +
                "name='" + name + '\'' +
                '}';
    }

    @Deprecated
    @MethodInfo(date = "12.04.2019", author = "user")
    public void someVoid(){
        System.out.println("Deprecated void");
    }

    public static void main(String[] args) {
        //
        AnnotationExample example = new AnnotationExample();
        Method[] methods = example.getClass().getDeclaredMethods();
        for (Method method: methods){
            Annotation[] annotations = method.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));

            method.isAnnotationPresent(MethodInfo.class);

            MethodInfo methodInfo = method.getDeclaredAnnotation(MethodInfo.class);
            System.out.println(methodInfo);
            if (methodInfo != null){
                System.out.println(methodInfo.version());
                System.out.println(methodInfo.date());
                System.out.println(methodInfo.author());
            }
        }
    }
}
