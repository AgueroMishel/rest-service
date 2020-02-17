package Formatters.Enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class IntegerFormatEnumDeserializer extends JsonDeserializer<IntegerFormat> {
    @Override
    public IntegerFormat deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        final String jsonValue = parser.getText();

        for(final IntegerFormat enumValue : IntegerFormat.values()) {
            if (enumValue.getStringValue().equals(jsonValue)) {
                return enumValue;
            }
        }

        return IntegerFormat.NOFORMAT;
    }
}
