package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;
import utils.Container;
import utils.WaitUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class MostPlayedPage {

    By chartBy = By.xpath("//*[contains(@class, 'weeklytopsellers_ChartTable')]");
    private Container chart = new Container(chartBy);

    public boolean isMostPlayedPageOpened() {
        WaitUtils.waitForElementToAppear(chartBy, 5);
        return chart.isDisplayed();
    }

    public int getNumberOfCurrentPlayers(int index) throws ParseException {
        List<WebElement> currentPlayers = Browser.getDriver().findElements(By.xpath("//td[contains(@class, 'ConcurrentCell')]"));
        NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        return format.parse(currentPlayers.get(index).getText()).intValue();
    }

}
