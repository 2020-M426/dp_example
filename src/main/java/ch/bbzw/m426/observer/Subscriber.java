package ch.bbzw.m426.observer;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Subscriber implements Subscribable {

    private final String name;
    {
        final Random random = new Random();
        final IntStream stream = random.ints(4, 900, 1000);
        final StringBuilder result = new StringBuilder();
        stream.forEach(result::append);
        name = result.toString();
    }

    @Override
    public void update(final Message message) {
        System.out.printf("%s: %s%n", name, message);
    }
}
