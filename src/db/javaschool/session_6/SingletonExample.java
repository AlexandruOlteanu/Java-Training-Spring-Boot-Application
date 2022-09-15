package db.javaschool.session_6;

public class SingletonExample {
    private static SingletonExample instance = null;

    private SingletonExample() {

    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }

        return instance;
    }
}
