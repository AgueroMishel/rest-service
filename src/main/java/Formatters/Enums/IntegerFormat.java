package Formatters.Enums;

public enum IntegerFormat {
    COMMA("comma", ","),
    DOT("dot", "."),
    NOFORMAT("noformat", "");

    private String enumStringValue;
    private String charValue;

    IntegerFormat(String enumStringValue, String charValue) {
        this.enumStringValue = enumStringValue;
        this.charValue = charValue;
    }

    public String getEnumStringValue() {
        return enumStringValue;
    }

    public String getCharValue() {
        return charValue;
    }
}
