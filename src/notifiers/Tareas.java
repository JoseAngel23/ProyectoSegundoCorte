package notifiers;

import java.util.ArrayList;
import java.util.List;

import interfaces.ISuscriber;

public class Tareas {
    private List<ISuscriber> subscribers = new ArrayList<>();
    
    public void attach(ISuscriber subscriber) {
        this.subscribers.add(subscriber);
    }
    
    public void detach (ISuscriber subscriber) {
        this.subscribers.remove(subscriber);
    }
    
    public void notify(String message) {
        for (ISuscriber subscriber : this.subscribers) {
            subscriber.update(message);
        }
    }
}
