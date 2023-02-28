package pizza;

public class VeggiPizza implements Pizza{
    @Override
    public String prepare() {
        return "Veggi Pizza";
    }

    @Override
    public double price() {
        return 550.0;
    }
}
