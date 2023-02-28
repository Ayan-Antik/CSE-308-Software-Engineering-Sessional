package pizza.pizzadecorator;

import pizza.Pizza;

public abstract class PizzaDecorator implements Pizza {
    private Pizza mypizza;
    public PizzaDecorator(Pizza mypizza){
        this.mypizza = mypizza;
    }

    @Override
    public String prepare() {
        return mypizza.prepare();
    }

    @Override
    public double price() {
        return mypizza.price() + 100.0;
    }
}
