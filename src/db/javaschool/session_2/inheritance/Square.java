package db.javaschool.session_2.inheritance;

public class Square extends Shape {
    Square(double[] laturi) {
        super(laturi);
    }
    Square(String color, double[] laturi) {

        super(color, laturi);
    }

    @Override
    public double getArie() {
        arie = laturi[0] * laturi[0];
        return arie;
    }
}
