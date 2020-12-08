package ch.bbzw.m426.observer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Message {

    private final String message;

    @Override
    public String toString() {
        return this.message;
    }

}
