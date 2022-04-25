package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    Cars cars;

    public Cars play(String input) {
        try {
            if (!CarValidation.validateCarName(input)) {
                throw new IllegalArgumentException("[ERROR] 정확한 자동차 이름을 입력해 주세요");
            }
            splitCar(input);
        } catch (Exception e) {
            printErrorMessage(e);
        }
        return cars;
    }

    private void printErrorMessage(Exception e) {
        e.printStackTrace();
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        restartGame();
    }

    private void restartGame() {
        play(Console.readLine());
    }

    public Cars attemptRacingCar(Cars cars, int attempt) {
        for (int i = 0; i < attempt; i++) {
            moveCars(cars);
        }
        return cars;
    }

    private void moveCars(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void splitCar(String input) {
        String[] names = input.split(",");
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            carsList.add(new Car(new CarName(names[i]), new CarPosition()));
        }
        cars = new Cars(carsList);
    }
}
