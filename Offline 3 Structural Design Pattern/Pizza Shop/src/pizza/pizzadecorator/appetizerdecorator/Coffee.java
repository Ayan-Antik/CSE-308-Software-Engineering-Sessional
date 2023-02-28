package pizza.pizzadecorator.appetizerdecorator;

import pizza.Pizza;

public class Coffee extends AppetizerDecorator {
    public Coffee(Pizza mypizza) {
        super(mypizza);
    }

    @Override
    public String prepare() {
        return super.prepare() + " and Coffee";
    }

    @Override
    public double price() {
        return super.price() + 210.0;
    }
}
