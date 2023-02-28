package pizza.pizzadecorator.appetizerdecorator;

import pizza.Pizza;

public class Coke extends AppetizerDecorator {
    public Coke(Pizza mypizza) {
        super(mypizza);
    }

    @Override
    public String prepare() {
        return super.prepare() + " and Coke";
    }

    @Override
    public double price() {
        return super.price() + 50.0;
    }
}
