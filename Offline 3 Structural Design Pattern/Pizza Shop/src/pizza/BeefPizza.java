package pizza;

public class BeefPizza implements Pizza {
    @Override
    public String prepare() {
        return "Beef Pizza";
    }

    @Override
    public double price() {
        return 750.0;
    }
}
