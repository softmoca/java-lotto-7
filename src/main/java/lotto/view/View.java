package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static void promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static long inputLottoPurchaseAmount() {
        String amountInput = Console.readLine();
        validatePurchaseAmount(amountInput);
        return Long.parseLong(amountInput);
    }

    private static void validatePurchaseAmount(String inputValue) {
        validateNumeric(inputValue);
        validateEmpty(inputValue);
        validateNegative(inputValue);
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private static void validateNumeric(String inputValue) {
        try {
            Long.parseLong(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자 형식이 아닙니다.");
        }
    }

    private static void validateNegative(String inputValue) {
        if (Long.parseLong(inputValue) < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수가 될 수 없습니다.");
        }
    }

}