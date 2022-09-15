package db.javaschool.session_2.inheritance;

public class Circle extends Shape {

    double raza;

    {
        System.out.println("Circle NOT-Static");
    }

    static{
        System.out.println("Circle Static");
    }

    Circle(String color, double raza) {
        super(color); // reutilizare de cod
        this.raza = raza;
    }

    @Override
    public double getPerimetru(){
//        super.getPerimetru(); // getPerimetru::Shape
        perimetru = 2 * Math.PI * raza;
        return perimetru;
    }

    @Override
    public double getArie(){
        arie = Math.PI * raza * raza;
        return arie;
    }

    public double getRaza() {
        return raza;
    }


}
