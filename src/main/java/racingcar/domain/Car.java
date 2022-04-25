package racingcar.domain;

public class Car {

    private CarPosition position;
    private CarName name;

    public Car(final String name, CarPosition position) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public void move(int number) {
        if (number >= 4) {
            position = position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public CarName getName() {
        return name;
    }
}
