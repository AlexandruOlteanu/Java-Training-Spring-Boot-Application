package db.javaschool.session_3.exceptions;

public class MainNullPointer {
    public int x;

    public void method() throws RuntimeException {
        throw new RuntimeException("This is a RuntimeException.");
//        throw new StackOverflowError();
    }

    public static void main(String[] args) {
        class A { public int x; }

        MainNullPointer a = new MainNullPointer();
        a.x = 3;

        try {
            a.method();
        } catch (RuntimeException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }

        try {
            a = null;
            a.x = 4;
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } catch (RuntimeException e) {  // if (e instanceof RuntimeException)
            System.out.println("RuntimeException");
        } catch (Exception e) { // if (e instanceof Exception)
            System.out.println("Generic Exception");
        } finally { // se executa indiferent de caz
            System.out.println("Finally block");
        }

        System.out.println("Aici");
    }
}
