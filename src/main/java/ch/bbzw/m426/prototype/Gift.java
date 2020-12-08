package ch.bbzw.m426.prototype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Gift {
    private String name;
    private GiftColor color;

    public abstract Gift clone();

    @Override
    public String toString() {
        return String.format("%s-%s", name, color);
    }
}
