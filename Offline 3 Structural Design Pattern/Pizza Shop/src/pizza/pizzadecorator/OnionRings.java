package pizza.pizzadecorator;

import pizza.Pizza;

public class OnionRings extends PizzaDecorator {
    public OnionRings(Pizza mypizza) {
        super(mypizza);
    }

    @Override
    public String prepare() {
        return super.prepare() + " with Onion Rings";
    }
    
}
