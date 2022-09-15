package db.javaschool.session_5.threading;

import java.util.concurrent.locks.Lock;

public class ExampleClass {
    public int a = 0;

    public synchronized void method1() {
        a++;
    }

    public void method2() {
        synchronized (this) {
            a++;
        }
    }

    public void method3() {
        a++;
    }


}
