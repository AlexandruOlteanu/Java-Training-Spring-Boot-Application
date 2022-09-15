package db.javaschool.session_9;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface AnnotationTypeExample {
    int value() default 0;
}
