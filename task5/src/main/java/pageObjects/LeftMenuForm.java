package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;
import utils.Button;
import utils.Identifier;

import java.util.List;

public class LeftMenuForm extends BaseForm {

    private Button optionsAndFiltersButton = new Button(By.xpath("//*[contains(@class, 'OpenFilterSettings')]"));
    public LeftMenuForm() {
        super(new Identifier(By.xpath("//*[contains(@class, 'NewsChannelGroup')]")));
    }

    public void clickOptionsAndFiltersButton() {
        optionsAndFiltersButton.click();
    }

    public void untickAllCheckboxes() {
        List<WebElement> checkboxes = Browser.getDriver().findElements(By.xpath("(//*[contains(@class,'FilterSubSection')])[1]//*[@id='base']"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
