package Model.Parsers;

import Exceptions.AnimalTypeParseException;
import Model.AnimalType;

public class AnimalTypeParser {

    public static AnimalType parse(String num) throws AnimalTypeParseException {
        try {
            Integer n = Integer.parseInt(num);
            if (n >= AnimalType.values().length || n < 0) {
                throw new AnimalTypeParseException("Значение вида животного вне диапазона", String.valueOf(n));
            }
            return AnimalType.values()[n];

        }
        catch (NumberFormatException e) {
            throw new AnimalTypeParseException("Некорректное значение вида животного",num);
        }
    }
}
