package Formatters;

import Formatters.Enums.IntegerFormat;

public class IntegerFormatter {
    private IntegerFormatter() {}

    public static String format(int number, IntegerFormat format) {
        int currentDigits;
        String formattedNumber = "";

        while(number > 0) {
            if(number > 999) {
                currentDigits = number % 1000;
                formattedNumber = format.getCharValue() + String.format("%03d", currentDigits) + formattedNumber;
            } else {
                formattedNumber = number + formattedNumber;
            }

            number = number / 1000;
        }

        return formattedNumber;
    }
}
