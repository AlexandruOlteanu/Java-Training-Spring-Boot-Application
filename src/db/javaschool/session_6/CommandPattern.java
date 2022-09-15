package db.javaschool.session_6;

class Dog {
    public void stay() {
        System.out.println("Dog received stay");
    }

    public void bring() {
        System.out.println("Dog received bring");
    }
}

abstract class Command {
    abstract void execute(Dog dog);
}
class CommandStay extends Command {
    public void execute(Dog dog) {
        dog.stay();
    }
}

class CommandBring extends Command {
    public void execute(Dog dog) {
        dog.bring();
    }
}
