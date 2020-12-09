package ch.bbzw.m426.builder;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// Make Car only buildable by its builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
//@Builder
public class Car {

    private final CarEngine engine;
    private final CarColor carColor;
    private final InteriorColor interiorColor;

    @Override
    public String toString() {
        return String.format("Car with engine %s, color %s and interior color %s", this.engine, this.carColor, this.interiorColor);
    }

    /* Lombok
    public static CarBuilder builder(CarEngine engine) {
        return new CarBuilder().engine(engine);
    }
    */

    public static class CarBuilder {
        private final CarEngine engine;
        private CarColor carColor;
        private InteriorColor interiorColor;

        public CarBuilder(final CarEngine engine) {
            this.engine = engine;
            this.carColor = CarColor.BLACK;
            this.interiorColor = InteriorColor.BLACK;
        }

        public void withColor(final CarColor carColor) {
            this.carColor = carColor;
        }

        public void withInteriorColor(final InteriorColor interiorColor) {
            this.interiorColor = interiorColor;
        }

        public Car build() {
            return new Car(this.engine, this.carColor, this.interiorColor);
        }
    }
}
