package Formatters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import Formatters.Enums.IntegerFormat;
import Formatters.Enums.IntegerFormatEnumDeserializer;

public class IntegerList {
    private IntegerFormat format;
    private int[] unformattedList;

    public IntegerList(
            @JsonProperty("format") @JsonDeserialize(using = IntegerFormatEnumDeserializer.class) IntegerFormat format,
            @JsonProperty("numbers") int[] numbers) {
        this.format = (format != null) ? format : IntegerFormat.NOFORMAT;
        this.unformattedList = (numbers != null) ? numbers : new int[0];
    }

    public IntegerFormat getFormat() {
        return format;
    }

    public int[] getUnformattedList() {
        return unformattedList;
    }
}
