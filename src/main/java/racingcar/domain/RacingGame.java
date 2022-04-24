package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    List<Car> carList = new ArrayList<>();

    public List<Car> play(String input) {
        try {
            if (!CarValidation.validateCarName(input)) {
                throw new IllegalArgumentException("[ERROR] 정확한 자동차 이름을 입력해 주세요");
            }
            splitCar(input);
        } catch (Exception e) {
            printErrorMessage(e);
        }
        return carList;
    }

    private void printErrorMessage(Exception e) {
        e.printStackTrace();
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        restartGame();
    }

    private void restartGame() {
        play(Console.readLine());
    }

    public List attemptRacingCar(List<Car> carList, int attempt) {
        for (int i = 0; i < attempt; i++) {
            moveCars(carList);
        }
        return carList;
    }

    private void moveCars(List<Car> carList) {
        for (Car car : carList) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void splitCar(String input) {
        String[] names = input.split(",");

        for (int i = 0; i < names.length; i++) {
            carList.add(new Car(new CarName(names[i]), new CarPosition()));
        }
    }
}
