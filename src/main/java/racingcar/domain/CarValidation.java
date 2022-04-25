package racingcar.domain;

public class CarValidation {

    public static boolean validateCarName(String input) {
        if (checkBlank(input)) return false;
        if (checkComma(input)) return false;

        if (checkLength(input.split(","))) return false;
        if (checkName(input.split(","))) return false;

        return true;
    }

    private static boolean checkName(String[] names) {
        for (String name : names) {
            if (validName(name)) return true;
        }
        return false;
    }

    private static boolean validName(String name) {
        if (!isNameValid(name)) {
            throw new IllegalArgumentException("[ERROR] 정확한 자동차 이름 자리수를 입력해 주세요");
        }

        if (!isTrimNameValid(name)) {
            throw new IllegalArgumentException("[ERROR] 정확한 자동차 이름 자리수를 입력해 주세요");
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
            throw new IllegalArgumentException("[ERROR] 정확한 자동차 이름을 입력해 주세요");
        }
        return false;
    }

    private static boolean checkComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        }
        return false;
    }

    private static boolean checkBlank(String input) {
        if ("".equals(input) || " ".equals(input)) {
            throw new IllegalArgumentException("[ERROR] 정확한 자동차 이름을 입력해 주세요");
        }
        return false;
    }
}
