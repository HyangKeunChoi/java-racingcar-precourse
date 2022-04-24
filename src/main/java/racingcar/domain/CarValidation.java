package racingcar.domain;

public class CarValidation {

    public static boolean validateCarName(String input) {

        if ("".equals(input) || " ".equals(input)) {
            return false;
        }

        if (!input.contains(",")) {
            return false;
        }
        String[] splitInput = input.split(",");
        if (splitInput.length < 2) {
            return false;
        }
        for (String name : splitInput) {
            if (!(name.length() >= 1 && name.length() <= 5)) {
                return false;
            }

            if (!(name.length() == name.trim().length())) {
                return false;
            }
        }
        return true;
    }
}
