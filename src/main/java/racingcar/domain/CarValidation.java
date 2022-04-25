package racingcar.domain;

import racingcar.constant.ConstantMessage;
import racingcar.constant.ConstantNumber;

public class CarValidation {

    public static boolean validateCarName(String input) {
        if (checkBlank(input)) return false;
        if (checkComma(input)) return false;

        if (checkLength(input.split(ConstantMessage.COMMA))) return false;
        if (checkName(input.split(ConstantMessage.COMMA))) return false;

        return true;
    }

    private static boolean checkName(String[] names) {
        for (String name : names) {
            validName(name);
        }
        return false;
    }

    private static boolean validName(String name) {
        if (!isNameValid(name)) {
            throw new IllegalArgumentException(ConstantMessage.IS_NOT_VALID_CAR_LENGTH);
        }

        if (!isTrimNameValid(name)) {
            throw new IllegalArgumentException(ConstantMessage.IS_NOT_VALID_CAR_LENGTH);
        }
        return false;
    }

    private static boolean isTrimNameValid(String name) {
        return name.length() == name.trim().length();
    }

    private static boolean isNameValid(String name) {
        return name.length() >= ConstantNumber.MINIMUN_NAME_LENGTH && name.length() <= ConstantNumber.MAXIMUN_NAME_LENGTH;
    }

    private static boolean checkLength(String[] splitInput) {
        if (splitInput.length < ConstantNumber.CAN_PARTICIPATE_CAR) {
            throw new IllegalArgumentException(ConstantMessage.CAN_PARTICIPATE_CAR);
        }
        return false;
    }

    private static boolean checkComma(String input) {
        if (!input.contains(ConstantMessage.COMMA)) {
            throw new IllegalArgumentException(ConstantMessage.SPLIT_CAR_NAME_BY_COMMA);
        }
        return false;
    }

    private static boolean checkBlank(String input) {
        if ("".equals(input) || " ".equals(input)) {
            throw new IllegalArgumentException(ConstantMessage.PLEASE_INPUT_RIGHT_CAR_NAME);
        }
        return false;
    }
}
