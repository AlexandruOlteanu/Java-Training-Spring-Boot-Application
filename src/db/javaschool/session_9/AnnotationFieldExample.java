package db.javaschool.session_9;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface AnnotationFieldExample {
    String value();
}
