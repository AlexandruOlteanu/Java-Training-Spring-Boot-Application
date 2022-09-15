package db.javaschool.session_9;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        AnnotatedClass ac = new AnnotatedClass();

        try {
            Class<?> clazz = ac.getClass();
            Method method = clazz.getMethod("annotatedMethod");

            if (method.isAnnotationPresent(AnnotationExample.class)) {
                AnnotationExample ann = method.getAnnotation(AnnotationExample.class);
                System.out.println(ann.annotatedValue());
            }

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        Class<?> clazz = ac.getClass();
        if (clazz.isAnnotationPresent(AnnotationTypeExample.class)) {
            AnnotationTypeExample ann = clazz.getAnnotation(AnnotationTypeExample.class);
            System.out.println(ann.value());
        }

        Field[] fields = ac.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true); // if private
                Class<?> fieldType = field.getType();

                String columnName = null;
                if (field.isAnnotationPresent(AnnotationFieldExample.class)) {
                    columnName = field.getAnnotation(AnnotationFieldExample.class).value();
                }

                String columnValue = null;
                int columnIntValue;
                if (fieldType.isAssignableFrom(String.class)) {
                    columnValue = (String) field.get(ac);
                } else if (fieldType.isPrimitive() && field.getInt(ac) != 0) {
                    columnIntValue = field.getInt(ac);
                }
                // else if(fieldType.isAssignableFrom(...)

                System.out.println(columnName + " " + columnValue);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
