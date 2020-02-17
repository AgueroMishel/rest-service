package Formatters.Enums;

public enum IntegerFormat {
    COMMA("comma", ","),
    DOT("dot", "."),
    NOFORMAT("noformat", "");

    private String stringValue;
    private String value;

    IntegerFormat(String stringValue, String value) {
        this.stringValue = stringValue;
        this.value = value;
    }

    public String getStringValue() {
        return stringValue;
    }

    public String getValue() {
        return value;
    }
}
