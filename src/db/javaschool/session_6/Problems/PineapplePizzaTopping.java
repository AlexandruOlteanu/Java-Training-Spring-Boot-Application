package db.javaschool.session_6.Problems;

public class PineapplePizzaTopping extends PizzaTopping{
    public PineapplePizzaTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void addTopping() {
        toppings.add(PizzaToppingType.PINEAPPLE);
    }

    @Override
    public String toString() {
        return pizza.toString()+ " with Pineapple";
    }
}
