package db.javaschool.session_5.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
//        RunnableExample r1 = new RunnableExample();
//        RunnableExample r2 = new RunnableExample();
//        RunnableExample r3 = new RunnableExample();
//
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//        Thread t3 = new Thread(r3);
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        try {
//            t1.join();
//            t2.join();
//            t3.join();
//        } catch (InterruptedException e) {
//            System.out.println("Thread interrupted.");
//        }
//
//        System.out.println("------------ ALL THREADS FINISHED ------------------");
//
//        ExtendsThreadExample et1 = new ExtendsThreadExample();
//        ExtendsThreadExample et2 = new ExtendsThreadExample();
//        ExtendsThreadExample et3 = new ExtendsThreadExample();
//
//        et1.start();
//        et2.start();
//        et3.start();
//
//        try {
//            et1.join();
//            et2.join();
//            et3.join();
//        } catch (InterruptedException e) {
//            System.out.println("Thread interrupted.");
//        }
//
//        System.out.println("------------ ALL THREADS FINISHED ------------------");
//
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        executor.execute(new RunnableExample());
//        executor.execute(new RunnableExample());
//        executor.execute(new RunnableExample());
//        executor.shutdown();

        int a = 3;
        a++;
        // read a
        // increment a
        // write a

        ExampleClass e = new ExampleClass();
        Lock lock = new ReentrantLock();
        ExtendsThreadExample et1 = new ExtendsThreadExample(e, lock);
        ExtendsThreadExample et2 = new ExtendsThreadExample(e, lock);

        et1.start();
        et2.start();

        try {
            et1.join();
            et2.join();
        } catch (InterruptedException ex) {
            System.out.println("Threads interrupted.");
        }

        System.out.println(e.a); // 4

    }
}
