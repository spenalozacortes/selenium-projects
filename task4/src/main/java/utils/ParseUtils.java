package utils;

import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class ParseUtils {

    public static int formatToInt(List<WebElement> elements, int index) throws ParseException {
        NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        return format.parse(elements.get(index).getText()).intValue();
    }
}
