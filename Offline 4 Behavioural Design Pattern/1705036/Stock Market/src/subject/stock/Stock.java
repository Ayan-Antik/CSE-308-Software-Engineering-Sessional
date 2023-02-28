package subject.stock;

import subject.observer.ObserverThread;

import java.util.*;

public class Stock implements iStock{
    private String name;
    private int count;
    private float price;

    private List<ObserverThread> subscribers;

    public Stock(String name, int count, float price) {
        this.name = name;
        this.count = count;
        this.price = price;
        subscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        notifyAllSubscribers(name + " Stock count changed to " + String.valueOf(this.count));
    }

    public float getPrice() {
        return price;
    }

    public void increasePrice(float price) {
        System.out.println("Price Increase...");
        this.price += price;
        notifyAllSubscribers(name + " Stock price increase. New Price: " + String.valueOf(this.price));
    }
    public void decreasePrice(float price) {
        System.out.println("Price Decrease...");
        this.price -= price;
        notifyAllSubscribers(name + " Stock price decrease. New Price: " + String.valueOf(this.price));
    }

    @Override
    public void subscribe(ObserverThread subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ObserverThread subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAllSubscribers(String s) {
        for (int i = 0; i< subscribers.size(); i++){
            subscribers.get(i).update(s);
        }
    }

}
