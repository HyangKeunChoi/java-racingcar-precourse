package racingcar.domain;

public class CarValidation {

    public static boolean validateCarName(String input) {
        if (checkBlank(input)) return false;
        if (checkComma(input)) return false;

        if (checkLength(input.split(","))) return false;
        for (String name : input.split(",")) {
            if (checkName(name)) return false;
        }
        return true;
    }

    private static boolean checkName(String name) {
        if (!isNameValid(name)) {
            return true;
        }
        if (!isTrimNameValid(name)) {
            return true;
        }
        return false;
    }

    private static boolean isTrimNameValid(String name) {
        return name.length() == name.trim().length();
    }

    private static boolean isNameValid(String name) {
        return name.length() >= 1 && name.length() <= 5;
    }

    private static boolean checkLength(String[] splitInput) {
        if (splitInput.length < 2) {
            return true;
        }
        return false;
    }

    private static boolean checkComma(String input) {
        if (!input.contains(",")) {
            return true;
        }
        return false;
    }

    private static boolean checkBlank(String input) {
        if ("".equals(input) || " ".equals(input)) {
            return true;
        }
        return false;
    }
}
