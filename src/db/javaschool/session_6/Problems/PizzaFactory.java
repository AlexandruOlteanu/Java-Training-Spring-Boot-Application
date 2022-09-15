package db.javaschool.session_6.Problems;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactory {

    private static PizzaFactory instance = null;
    private List<Client> listClients = new ArrayList<>();

    private PizzaFactory() {}

    public synchronized static PizzaFactory getInstance() {
        if(instance == null) {
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza bakePizza(PizzaType pizzaType, PizzaToppingType toppingType) {
        Pizza pizza = switch (pizzaType) {
            case MARGHERITA -> new MargheritaPizza();
            case CAPRICIOSA -> new CapriciosaPizza();
            case QUATRO_STAGIONI -> new QuatroStagioniPizza();
            case PROSCIUTTO_FUNGHI -> new ProsciuttoFunghiPizza();
        };

        pizza = switch (toppingType){
            case PINEAPPLE -> new PineapplePizzaTopping(pizza);
            case MOZZARELLA -> new MozzarellaPizzaTopping(pizza);
            case NONE -> pizza;
        };

        for (Client client : listClients){
            client.receiveNotify(pizza.toString());
        }
        return pizza;
    }

    public void addClient(Client client){
        listClients.add(client);
    }




}

