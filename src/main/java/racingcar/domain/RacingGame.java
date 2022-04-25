package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    Cars cars;

    public Cars play(String input) {
        try {
            CarValidation.validateCarName(input);
            splitCar(input);
        } catch (Exception e) {
            printErrorMessage(e);
        }
        return cars;
    }

    private void printErrorMessage(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
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
            carsList.add(new Car(names[i], new CarPosition()));
        }
        cars = new Cars(carsList);
    }

    public void drawCarMove(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName().getName() + " : ");
            drawCarMoveBar(car);
            System.out.println();
        }
    }

    private void drawCarMoveBar(Car car) {
        for(int i = 0; i< car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public void printWinnerCar(Cars cars) {
        int maxPostition = 0;
        for (Car car : cars.getCars()) {
            if(maxPostition < car.getPosition()) {
                maxPostition = car.getPosition();
            }
        }

        List<String> winnerCar = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if(car.getPosition() == maxPostition) {
                winnerCar.add(car.getName().getName());
            }
        }

        if(winnerCar.size() == 1) {
            System.out.println("최종 우승자: " + winnerCar.get(0));
        }

        if(winnerCar.size() != 1) {
            System.out.println("최종 우승자: " + String.join(",", winnerCar));
        }
    }
}
