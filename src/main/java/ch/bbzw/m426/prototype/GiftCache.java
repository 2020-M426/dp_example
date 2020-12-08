package ch.bbzw.m426.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GiftCache {
    private final Map<String, Gift> cache = new HashMap<>();

    public Gift put(final String name, final Gift gift) {
        cache.put(name, gift);
        return gift;
    }

    public Optional<Gift> get(final String name) {
        if (cache.containsKey(name)) {
            return Optional.of(cache.get(name).clone());
        }
        return Optional.empty();
    }
}
