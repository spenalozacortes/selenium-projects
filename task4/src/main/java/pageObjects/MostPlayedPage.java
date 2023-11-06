package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;
import utils.Identifier;
import utils.ParseUtils;

import java.text.ParseException;
import java.util.List;

public class MostPlayedPage extends BaseForm {

    public MostPlayedPage() {
        super(new Identifier(By.xpath("//*[contains(@class, 'weeklytopsellers_ChartTable')]")));
    }

    public int getNumberOfCurrentPlayers(int index) throws ParseException {
        List<WebElement> currentPlayers =  Browser.getDriver().findElements(By.xpath("//td[contains(@class, 'ConcurrentCell')]"));
        return ParseUtils.formatToInt(currentPlayers, index);
    }
}
