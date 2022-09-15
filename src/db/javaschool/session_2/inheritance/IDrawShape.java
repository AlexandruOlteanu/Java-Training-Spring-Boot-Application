package db.javaschool.session_2.inheritance;

import java.io.File;

public interface IDrawShape {
    final int x = 0;

    void draw(Shape shape); // abstract
    void read(File shapeFile); // abstract
    void write_to_file(Shape shape); // abstract
}
