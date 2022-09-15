package db.javaschool.session_4.generics;

public class GenericClass<T>{

    T x;
    public void genericMethod(T element) {
        System.out.println(element);
    }

    public static void main(String[] args) {
        GenericClass<String> g = new GenericClass();
        g.genericMethod("Hello world!");

        GenericClass.<String>print("Hello world!");
    }

    public static<N> void print(N arg) {
        System.out.println(arg);
    }
}
