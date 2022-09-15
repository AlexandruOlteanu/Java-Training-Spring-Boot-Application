package db.javaschool.session_2.inheritance;

import java.io.File;

public class DrawShapeInPaint implements IDrawShape{
    @Override
    public void draw(Shape shape) {
        System.out.println("Draw shape to screen " + x);
    }

    @Override
    public void read(File shapeFile) {
        System.out.println("Read shape from file");
    }

    @Override
    public void write_to_file(Shape shape) {
        System.out.println("Write shape to file");
    }

    public void anotherFunction() {

    }
}
