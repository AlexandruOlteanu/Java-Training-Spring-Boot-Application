package db.javaschool.session_6.Problems;

public class MozzarellaPizzaTopping extends PizzaTopping {

    public MozzarellaPizzaTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void addTopping() {
        toppings.add(PizzaToppingType.MOZZARELLA);
    }

    @Override
    public String toString() {
        return pizza.toString()+ " with Mozzarella";
    }
}
