package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {
    private UiElement uiElement;

    public Checkbox(WebDriver driver, By locator) {
        this.uiElement = new UiElement(driver, locator);
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }

    private void setStatus(boolean status) {
        if (isSelected() != status) {
            uiElement.click();
        }
    }

    public void set() {
        setStatus(true);
    }

    public void remove() {
        setStatus(false);
    }
}
