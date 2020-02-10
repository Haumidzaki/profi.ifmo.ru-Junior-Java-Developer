package fitness;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessMode {
    String pool() default "22";  // "8/22"
    String gym() default "22";
    String group() default "22";
}
