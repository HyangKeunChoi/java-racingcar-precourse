package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @DisplayName("두 cars는 같다.")
    @Test
    void 두_cars_는_같다() {
        Car car1 = new Car(new CarName("pobi"), new CarPosition(1));
        Car car2 = new Car(new CarName("hyang"), new CarPosition(1));
        Car car3 = new Car(new CarName("hounx"), new CarPosition(1));
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        assertThat(new Cars(Arrays.asList(car1, car2, car3))).isEqualTo(cars);
    }
}