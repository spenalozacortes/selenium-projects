package pageObjects;

import org.openqa.selenium.By;
import utils.Button;
import utils.Identifier;

public class MiddleNavigationForm extends BaseForm {

    private Button newsButton = new Button(By.xpath("//a[contains(@class,'tab') and contains(@href,'news')]"));
    public MiddleNavigationForm() {
        super(new Identifier(By.id("store_nav_area")));
    }

    public void clickNewsButton() {
        newsButton.click();
    }
}
