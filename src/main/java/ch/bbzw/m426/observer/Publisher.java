package ch.bbzw.m426.observer;

import java.util.HashMap;
import java.util.Map;

public class Publisher {
    Map<String, Subscribable> subscribers = new HashMap<>();

    public void subscribe(final String name, final Subscribable subscriber) {
        subscribers.put(name, subscriber);
    }

    public void notify(final String name, final Message message) {
        if (subscribers.containsKey(name)) {
            subscribers.get(name).update(message);
        }
    }

    public void notifyAll(final Message message) {
        for (final Subscribable subscribable : subscribers.values()) {
            subscribable.update(message);
        }
    }
}
