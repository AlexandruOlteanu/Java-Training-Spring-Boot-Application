package db.javaschool.session_5.threading;

public class RunnableExample implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
    }
}
