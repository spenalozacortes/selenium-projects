package utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParseUtils {

    public static int formatToInt(String number) throws ParseException {
        NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        return format.parse(number).intValue();
    }
}
