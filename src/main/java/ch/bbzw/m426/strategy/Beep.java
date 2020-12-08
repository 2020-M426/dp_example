package ch.bbzw.m426.strategy;

public class Beep implements PushStrategy {
    @Override
    public void execute() {
        System.out.println("Beep");
    }
}
