package racingcar.domain;

public class Car {

    private CarPosition position;
    private CarName name;

    public Car(CarName name, CarPosition position) {
        CarValidation.validateCarName(name);
        this.name = new CarName();
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
}
