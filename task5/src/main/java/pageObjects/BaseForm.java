package pageObjects;

import utils.BaseElement;

public class BaseForm {
    private final BaseElement uniqueElement;

    public BaseForm(BaseElement uniqueElement) {
        this.uniqueElement = uniqueElement;
    }

    public boolean isPageOpen() {
        return uniqueElement.isDisplayed();
    }
}
