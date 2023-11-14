package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.view.OutputView.printOrderMenuQueryMessage;
import static christmas.view.OutputView.printVisitDateQueryMessage;

public class InputView {

    public static int inputDateOfVisit() {
        printVisitDateQueryMessage();
        int visitDateOfDec = Integer.parseInt(Console.readLine());
        // 검증 필요

        return visitDateOfDec;
    }

    public static Map<String, Integer> inputOrderMenu() {
        printOrderMenuQueryMessage();
        String orderItems = Console.readLine();

        return splitNameAndCount(splitByMenu(orderItems));
    }


    //** 입력 로직 ** //
    private static List<String> splitByMenu(String order) {
        return Arrays.stream(order.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static Map<String, Integer> splitNameAndCount(List<String> menus) {
        return menus.stream()
                .map(menu -> menu.split("-"))
                .filter(parts -> parts.length == 2)
                .collect(Collectors.toMap(
                        parts -> parts[0].trim(),
                        parts -> Integer.parseInt(parts[1].trim())
                ));
    }
}
