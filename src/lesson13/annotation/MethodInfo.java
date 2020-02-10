package lesson13.annotation;

import java.lang.annotation.*;

//@Documented
@Target(ElementType.METHOD)
// TYPE
// METHOD
// FIELD
// CONSTRUCTOR
// PARAMETER
//@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String date();
    String author();
    int version() default 1;
}


