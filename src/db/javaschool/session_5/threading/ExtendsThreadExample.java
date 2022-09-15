package db.javaschool.session_5.threading;

import java.util.concurrent.locks.Lock;

public class ExtendsThreadExample extends Thread {
    public ExampleClass e;
    private Lock lock;

    ExtendsThreadExample(ExampleClass e, Lock lock) {
        this.e = e;
        this.lock = lock;
    }

    @Override
    public void run() {
        e.method1();
        e.method2();

        lock.lock();
        try {
            e.method3();
        } finally {
            lock.unlock();
        }
    }
}
