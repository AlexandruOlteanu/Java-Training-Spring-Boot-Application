package db.javaschool.session_6.Problems;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaTopping extends Pizza{
    protected Pizza pizza;
    protected List<PizzaToppingType> toppings = new ArrayList<>();

    public PizzaTopping(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    public abstract void addTopping();
}
