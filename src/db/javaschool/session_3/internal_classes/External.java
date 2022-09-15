package db.javaschool.session_3.internal_classes;

public class External {
    public int x;

    public void method1() {
        System.out.println("Method1");
        this.x = 3; // this instanceof External
    }

    class Intern {
        public int y;

        public void method2() {
            System.out.println("Method2");
            this.y = 3; // this instanceof Intern
            External.this.x = 3; // External.this instanceof External
        }
    }
}
