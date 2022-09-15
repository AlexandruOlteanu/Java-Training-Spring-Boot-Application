package db.javaschool.session_9;

@AnnotationTypeExample(value=3)
public class AnnotatedClass { // TYPE

    @AnnotationFieldExample("column_x")
    private String x = "hello"; // FIELD

    @AnnotationFieldExample("column_y")
    private String y = "nice"; // FIELD

    @AnnotationFieldExample("column_z")
    private String z = "world!"; // FIELD

    @AnnotationExample(annotatedValue="Hello World!")
    public void annotatedMethod() {} // METHOD
}
