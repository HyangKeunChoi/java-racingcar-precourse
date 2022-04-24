package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarValidationTest {

    @BeforeEach
    void setUp() {

    }

    @DisplayName("경주에 참가하는 자동차는 2대 이상이다.")
    @Test
    void 경주에_참가하는_자동차는_2대이상이다() {
        boolean moreThanTwoCar = CarValidation.validateCarName(new CarName("pobi,hyang"));
        assertThat(moreThanTwoCar).isTrue();
    }

    @DisplayName("경주에 참가하는 자동차는 1대이면 안된다.")
    @Test
    void 경주에_참가하는_자동차는_1대는_안된다() {
        boolean oneCar = CarValidation.validateCarName(new CarName("pobi,"));
        assertThat(oneCar).isFalse();
    }

    @DisplayName("경주에 참가하는 자동차의 이름에 공백이 있으면 안된다.")
    @Test
    void 경주에_참가하는_자동차의_이름은_공백이_있으면_안된다() {
        boolean blankCars = CarValidation.validateCarName(new CarName("pobi, Hyan"));
        assertThat(blankCars).isFalse();
    }

    @DisplayName("경주에 참가하는 자동차의 이름은 1자 이상 5자 이하이다")
    @Test
    void 경주에_참가하는_자동차의_이름은_1자_이상_5자_이하이다() {
        boolean zeroNameCar = CarValidation.validateCarName(new CarName(",HyanA"));
        assertThat(zeroNameCar).isFalse();

        boolean moreThanFiveNameCar = CarValidation.validateCarName(new CarName("pobi,HyangKeun"));
        assertThat(moreThanFiveNameCar).isFalse();

    }

}