package pageObjects;

import org.openqa.selenium.By;
import utils.Identifier;

public class StorePage extends BaseForm {

    public MiddleNavigationForm middleNavigationForm = new MiddleNavigationForm();

    public StorePage() {
        super(new Identifier(By.cssSelector(".home_page_content")));
    }
}
