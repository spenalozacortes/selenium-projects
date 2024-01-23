package pageObjects;

import org.openqa.selenium.By;
import utils.Identifier;

public class MainPage extends BaseForm {

    public MiddleNavigationForm middleNavigationForm = new MiddleNavigationForm();

    public MainPage() {
        super(new Identifier(By.cssSelector(".home_page_content")));
    }
}
