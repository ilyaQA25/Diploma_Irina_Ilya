package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    private UiElement uiElement;

    public Button(WebDriver driver, By locator) {
        this.uiElement = new UiElement(driver, locator);
    }

    public void click() {
        uiElement.click();
    }

    public void submit() {
        uiElement.submit();
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }

    public boolean isEnabled() {
        return uiElement.isEnabled();
    }

}
