package Model.Parsers;

import Exceptions.BirthdayParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayParser {

    public static Date parse(String birthdayString) throws BirthdayParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(birthdayString);
        } catch (ParseException e) {
            throw new BirthdayParseException("Невозможно разобрать дату",birthdayString);
        }
        return birthday;
    }

}
