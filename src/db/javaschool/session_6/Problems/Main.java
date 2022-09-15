package db.javaschool.session_6.Problems;

public class Main {

    public static void main(String[] args) {

        PizzaFactory pizzaFactory = PizzaFactory.getInstance();
        Client client1 = new Client("Client1");
        Client client2 = new Client("Client2");

        client1.subscribe(pizzaFactory);
        client2.subscribe(pizzaFactory);

        OrderPizza orderPizza = new OrderPizza(pizzaFactory);
        orderPizza.commandPizza(PizzaType.MARGHERITA,PizzaToppingType.PINEAPPLE);
        orderPizza.commandPizza(PizzaType.QUATRO_STAGIONI, PizzaToppingType.NONE);

        

    }

}
