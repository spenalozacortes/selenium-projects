package pageObjects;

import org.openqa.selenium.By;
import utils.Identifier;
import utils.Text;

public class NewsPage extends BaseForm {

    public LeftMenuForm leftMenuForm = new LeftMenuForm();
    private Text message = new Text(By.cssSelector("[class*='EndOfRows'] div"));

    public NewsPage() {
        super(new Identifier(By.xpath("//*[contains(@class, 'NewsChannelGroup')]")));
    }

    public String getMessage() {
        return message.getText();
    }
}
