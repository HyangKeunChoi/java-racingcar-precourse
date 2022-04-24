package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    void 자동차가_움직인다() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPostion()).isEqualTo(1);
    }

    @Test
    void 자동차가_정지한다() {
        Car car = new Car("pobi");
        car.move(0);
        assertThat(car.getPostion()).isEqualTo(0);
    }
}