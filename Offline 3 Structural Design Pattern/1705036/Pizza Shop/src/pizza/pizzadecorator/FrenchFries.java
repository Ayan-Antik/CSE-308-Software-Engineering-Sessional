package pizza.pizzadecorator;

import pizza.Pizza;

public class FrenchFries extends PizzaDecorator {
    public FrenchFries(Pizza mypizza) {
        super(mypizza);
    }

    @Override
    public String prepare() {
        return super.prepare() + " with French Fries";
    }

}
