package db.javaschool.session_6.Problems;

public class Client {
    String name;

    public Client(String name){
        this.name = name;
    }

    public void receiveNotify(String msg){
        System.out.println(name + ": " + msg);
    }

    public void subscribe(PizzaFactory pizzaFactory){
        pizzaFactory.addClient(this);
    }
}
