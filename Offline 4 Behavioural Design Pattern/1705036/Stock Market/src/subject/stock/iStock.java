package subject.stock;

import subject.observer.ObserverThread;

public interface iStock {
    void notifyAllSubscribers(String s);
    void subscribe(ObserverThread subscriber);
    void unsubscribe(ObserverThread subscriber);

}
