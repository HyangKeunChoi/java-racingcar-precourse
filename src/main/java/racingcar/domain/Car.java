package racingcar.domain;

public class Car {

    private int position;
    private String name;

    public Car(String name, int position) {
        CarValidation.validateCarName(name);
        this.name = name;
        this.position = position;
    }

    public void move(int number) {
        if (number >= 4) {
            this.position += 1;
        }
    }

    public int getPostion() {
        return this.position;
    }
}
