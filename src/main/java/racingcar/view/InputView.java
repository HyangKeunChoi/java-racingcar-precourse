package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ConstantMessage;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class InputView {

    RacingGame racingGame = new RacingGame();

    public void startGame() {
        System.out.println(ConstantMessage.GAME_START_MESSAGE);
        Cars cars = racingGame.play(Console.readLine());
        System.out.println(ConstantMessage.GAME_TRIAL_COUNT);
        int trial = Integer.parseInt(Console.readLine());
        Cars resultCars = racingGame.attemptRacingCar(cars, trial);
        racingGame.drawCarMove(resultCars);
        racingGame.printWinnerCar(resultCars);
    }

}
