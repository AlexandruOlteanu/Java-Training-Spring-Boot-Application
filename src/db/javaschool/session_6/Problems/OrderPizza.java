package db.javaschool.session_6.Problems;

public class OrderPizza {
    public PizzaFactory pizzaFactory;
    OrderPizza(PizzaFactory pizzaFactory){
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza commandPizza(PizzaType pizzaType, PizzaToppingType toppingType){
        return pizzaFactory.bakePizza(pizzaType,toppingType);
    }
}
