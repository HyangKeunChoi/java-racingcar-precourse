package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

public class InputView {

    RacingGame racingGame = new RacingGame();

    public void startGame() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = racingGame.play(Console.readLine());
        System.out.println("시도할 횟수");
        int trial = Integer.parseInt(Console.readLine());
        List<Car> resultCars = racingGame.attemptRacingCar(cars, trial);
        for (Car car : resultCars) {
            System.out.println(car.getPosition());
        }
    }

}
