package ch.bbzw.m426.strategy;

import lombok.Setter;

public class UniButton {
    @Setter
    private PushStrategy strategy;

    public void executeStrategy() {
        this.strategy.execute();
    }
}
