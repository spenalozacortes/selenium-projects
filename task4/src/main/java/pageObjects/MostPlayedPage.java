package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;
import utils.Identifier;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class MostPlayedPage extends BaseForm {

    public MostPlayedPage() {
        super(new Identifier(By.xpath("//*[contains(@class, 'weeklytopsellers_ChartTable')]")));
    }

    public int getNumberOfCurrentPlayers(int index) throws ParseException {
        List<WebElement> currentPlayers =  Browser.getDriver().findElements(By.xpath("//td[contains(@class, 'ConcurrentCell')]"));
        NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        return format.parse(currentPlayers.get(index).getText()).intValue();
    }
}
