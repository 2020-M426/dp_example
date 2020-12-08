package ch.bbzw.m426.prototype;

public class Teddy extends Gift {

    @Override
    public Gift clone() {
        final Teddy teddy = new Teddy();
        teddy.setName(this.getName());
        teddy.setColor(this.getColor());
        return teddy;
    }
}
