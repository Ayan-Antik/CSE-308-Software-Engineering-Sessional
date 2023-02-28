import pizza.*;
import pizza.pizzadecorator.*;
import pizza.pizzadecorator.appetizerdecorator.Coffee;
import pizza.pizzadecorator.appetizerdecorator.Coke;

import java.util.Scanner;

public class DecoratorDemo {
    private static int ch;

    public static void main(String[] args){

            Pizza pizza;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Beef Pizza with French fry");
            System.out.println("2. Veggi Pizza with onion rings");
            System.out.println("3. A combo meal with Veggi Pizza, French Fry and Coke");
            System.out.println("4. A combo meal with Veggi Pizza, Onion Rings and Coffee");
            System.out.println("5. A Beef Pizza only");
            System.out.println("Enter choice: ");
            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();
            switch (ch){
                case 1:{
                    pizza = new FrenchFries(new BeefPizza());
                    System.out.println(pizza.prepare());
                    System.out.println(pizza.price());
                }
                break;

                case 2:{
                    pizza = new OnionRings(new VeggiPizza());
                    System.out.println(pizza.prepare());
                    System.out.println(pizza.price());
                }
                break;

                case 3:{
                    pizza = new Coke(new FrenchFries(new VeggiPizza()));
                    System.out.println(pizza.prepare());
                    System.out.println(pizza.price());
                }
                break;
                case 4:{
                    pizza = new Coffee(new OnionRings(new VeggiPizza()));
                    System.out.println(pizza.prepare());
                    System.out.println(pizza.price());
                }
                break;

                case 5:{
                    pizza = new BeefPizza();
                    System.out.println(pizza.prepare());
                    System.out.println(pizza.price());
                }
                break;

                default:{
                    System.out.println("Food choice unavailable");
                    break;
                }
            }

        }while (ch < 6);
    }
}
