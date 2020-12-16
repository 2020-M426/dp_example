package ch.bbzw.m426;

import ch.bbzw.m426.builder.Car;
import ch.bbzw.m426.builder.CarColor;
import ch.bbzw.m426.builder.CarEngine;
import ch.bbzw.m426.builder.InteriorColor;
import ch.bbzw.m426.observer.Message;
import ch.bbzw.m426.observer.Publisher;
import ch.bbzw.m426.observer.Subscribable;
import ch.bbzw.m426.observer.Subscriber;
import ch.bbzw.m426.prototype.Gift;
import ch.bbzw.m426.prototype.GiftCache;
import ch.bbzw.m426.prototype.GiftColor;
import ch.bbzw.m426.prototype.Teddy;
import ch.bbzw.m426.strategy.Beep;
import ch.bbzw.m426.strategy.Hoop;
import ch.bbzw.m426.strategy.UniButton;

public class Testli {
    public static void main(final String[] args) {
        // Builder
        /* Manual Builder */
        System.out.println("==BUILDER==");
        final Car grayBrownCar =
                new Car.CarBuilder(CarEngine.ELECTRONIC)
                        .withColor(CarColor.GRAY)
                        .withInteriorColor(InteriorColor.BROWN)
                        .build();
        System.out.println(grayBrownCar);

        // Lombok Builder
        final Car yellowGrayCar =
                Car.builder(CarEngine.RICH)
                        .carColor(CarColor.YELLOW)
                        .interiorColor(InteriorColor.GRAY)
                        .build();
        System.out.println(yellowGrayCar);

        // Prototype
        System.out.println("==PROTOTYPE==");
        final GiftCache cache = new GiftCache();
        // Try to get a new black teddy
        final Gift teddy_black = cache.get("TEDDY-BLACK").orElseGet(() -> {
            final Teddy tmp = new Teddy();
            tmp.setName("TEDDY");
            tmp.setColor(GiftColor.BLACK);
            return cache.put(tmp.toString(), tmp);
        }).clone();

        final Gift clone = teddy_black.clone();

        System.out.printf("Original: %s%n", teddy_black);
        System.out.printf("Clone: %s%n", clone);

        // Strategy
        System.out.println("==STRATEGY==");
        final UniButton button = new UniButton();
        final int strategy = 1;

        switch (strategy) {
            case 1:
                button.setStrategy(new Beep());
                break;
            case 2:
                button.setStrategy(new Hoop());
                break;
            default:
                button.setStrategy(() -> System.out.println("DEFAULT"));
        }

        button.executeStrategy();

        // Observer
        System.out.println("==OBSERVER==");
        final Publisher publisher = new Publisher();

        final Subscribable sub1 = new Subscriber();
        final Subscribable sub2 = new Subscriber();
        final Subscribable sub3 = new Subscriber();

        publisher.subscribe(sub1.toString(), sub1);
        publisher.subscribe(sub2.toString(), sub2);
        publisher.subscribe(sub3.toString(), sub3);

        publisher.notify(sub1.toString(), new Message("Sub1"));
        publisher.notifyAll(new Message("SubAll"));
    }
}
