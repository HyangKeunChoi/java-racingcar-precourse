package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarPositionTest {

    @Test
    void 자동차_위치를_잘꺼내오는지_테스트() {
        CarPosition cartPosition = new CarPosition(1);
        assertThat(cartPosition.getPosition()).isEqualTo(1);
    }

    @Test
    void 하나만큼_움직인_POSTION은_같은_객체이다() {
        CarPosition cartPosition = new CarPosition(1);
        assertThat(new CarPosition(1)).isEqualTo(cartPosition);
    }
}
