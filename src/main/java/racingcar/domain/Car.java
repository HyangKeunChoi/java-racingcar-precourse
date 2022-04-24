package racingcar.domain;

public class Car {

    private int position;

    public Car(String name) {
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
