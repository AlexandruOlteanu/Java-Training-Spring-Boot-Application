package db.javaschool.session_2.inheritance;

public class Main {
    public static void main(String[] args){
        Square s = new Square("Red",  new double[]{1,2,3,4});
        Square s2 = new Square(new double[]{1,2,3,4});
        System.out.println(s.getPerimetru());

        Circle c = new Circle("Blue", 3);
        System.out.println(c.getArie());
        System.out.println(c.raza); // 3


        // Upcasting - mai generic
        Shape cx = new Circle("Red", 4.1);
        System.out.println(cx.getClass());
        System.out.println(cx.getPerimetru()); // Apeleaza getPerimetru din Circle

        // Downcasting
        Circle cy = (Circle) cx;
        System.out.println(cy.getRaza());

        Square s3 = new Square(new double[] {3,3,3,3});
        Shape shape = s3; // Downcasting

        Circle circle;
        if (shape instanceof Circle)
            circle = (Circle) shape; // Upcasting
        else
            System.out.println("Nu putem face cast.");

        if (s3 instanceof Shape) {
            System.out.println("s3 is a shape.");
        }

        IDrawShape drawSystem = new DrawShapeInPaint();
        drawSystem.draw(s3);

        s3.clone();


        Shape new_shape = new Shape("Red") {
            @Override
            public double getArie() {
                return 0;
            }
        };

        new_shape.arie = 3;

        Cloneable x = new Cloneable() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

}
