package ru.job4j.srp.event;

import ru.job4j.srp.interfaces.CommonInputData;
import java.util.ArrayList;

/**
 * Class EventHandler
 *
 * @author Petr B.
 * @since 30.11.2019, 19:14
 */
public class EventHandler {
    private final CommonInputData commonInputData;
    private final double prev;

    public EventHandler(final CommonInputData inputData, final double prevResult) {
        commonInputData = inputData;
        prev = prevResult;
    }

    public ArrayList<Double> commonHandler() {
        double number = -1;
        String ask = null;
        ArrayList<Double> res = new ArrayList<>();
        for (int index = 0; index < 2; index++) {
            if (prev != -1) {
                ask = commonInputData.getAnwser("Вы хотите использовать предыдущий результат д/н?");
                if (ask.equals("д")) {
                    res.add(index, prev);
                } else {
                    try {
                        number = Double.parseDouble(commonInputData.getAnwser("Введите число: "));
                        res.add(index, number);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Вы вводите строку, а нужно число!");
                        index--;
                    }
                }
            } else {
                try {
                    number = Double.parseDouble(commonInputData.getAnwser("Введите число: "));
                    res.add(index, number);
                } catch (NumberFormatException nfe) {
                    System.out.println("Вы вводите строку, а нужно число!");
                    index--;
                }
            }
        }
        return res;
    }
}
