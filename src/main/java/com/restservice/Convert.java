package com.restservice;

public class Convert {
    private final String stringNumber;

    public Convert(int number) {
        this.stringNumber = convertNumberToCommaFormattedString(number);
    }

    public String getStringNumber() {
        return stringNumber;
    }

    private String convertNumberToCommaFormattedString(int number) {
        int currentDigits;
        String formattedNumber = "";

        while(number > 0) {
            if(number > 999) {
                currentDigits = number % 1000;
                formattedNumber = "," + String.format("%03d", currentDigits) + formattedNumber;
            } else {
                formattedNumber = number + formattedNumber;
            }

            number = number / 1000;
        }

        return formattedNumber;
    }
}
