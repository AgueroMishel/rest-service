package Formatters;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import Formatters.Enums.IntegerFormat;
import Formatters.Enums.IntegerFormatEnumDeserializer;

public class IntegerList {
    private IntegerFormat format;
    private List<Integer> unformattedList;

    public IntegerList(
            @JsonProperty("format") @JsonDeserialize(using = IntegerFormatEnumDeserializer.class) IntegerFormat format,
            @JsonProperty("numbers") List<Integer> numbers) {
        this.format = (format != null) ? format : IntegerFormat.NOFORMAT;
        this.unformattedList = (numbers != null) ? numbers : new ArrayList<>();
    }

    public IntegerFormat getFormat() {
        return format;
    }

    public List<Integer> getUnformattedList() {
        return unformattedList;
    }
}
