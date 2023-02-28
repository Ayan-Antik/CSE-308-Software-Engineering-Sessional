package pizza.pizzadecorator.appetizerdecorator;

import pizza.Pizza;

public abstract class AppetizerDecorator implements Pizza {
    private Pizza mypizza;

    public AppetizerDecorator(Pizza mypizza){
        this.mypizza = mypizza;
    }
    @Override
    public String prepare() {
        return mypizza.prepare();
    }

    @Override
    public double price() {
        return mypizza.price();
    }
}
