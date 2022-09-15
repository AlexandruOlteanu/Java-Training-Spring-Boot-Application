package db.javaschool.session_9;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface AnnotationExample {

    String annotatedValue() default "NO_VALUE";
}